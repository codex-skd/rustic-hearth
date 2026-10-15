package com.skd.rustichearth.client.storage;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.compat.quark.QuarkCompat;
import com.skd.rustichearth.item.VaseItem;
import com.skd.rustichearth.menu.storage.CabinetMenu;
import com.skd.rustichearth.menu.storage.DoubleCabinetMenu;
import com.skd.rustichearth.menu.storage.RusticBarrelMenu;
import com.skd.rustichearth.menu.storage.VaseMenu;
import com.skd.rustichearth.registry.ModBlockEntities;
import com.skd.rustichearth.registry.ModBlocks;
import com.skd.rustichearth.registry.ModMenus;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.server.packs.resources.ResourceManagerReloadListener;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterClientReloadListenersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.NeoForge;

/**
 * Client setup of the storage subsystem: screens, renderers, colors, models, client events.
 * Called from {@link com.skd.rustichearth.client.ClientSetup} on the physical client only.
 */
public final class StorageClientSetup {
	private StorageClientSetup() {
	}

	/** Register mod bus and {@code NeoForge.EVENT_BUS} client listeners here. */
	public static void init(IEventBus modBus) {
		modBus.addListener(StorageClientSetup::clientSetup);
		modBus.addListener(StorageClientSetup::registerScreens);
		modBus.addListener(StorageClientSetup::registerLayers);
		modBus.addListener(StorageClientSetup::registerRenderers);
		modBus.addListener(StorageClientSetup::registerClientExtensions);
		modBus.addListener(StorageClientSetup::registerReloadListeners);
		NeoForge.EVENT_BUS.addListener(VaseScrollHandler::onMouseScroll);
	}

	private static void clientSetup(FMLClientSetupEvent event) {
		// selects the vase item model override of the stack's design
		event.enqueueWork(() -> ItemProperties.register(ModBlocks.VASE.asItem(), RusticHearth.id("design"),
				(stack, level, entity, seed) -> VaseItem.getDesign(stack)));
	}

	private static void registerScreens(RegisterMenuScreensEvent event) {
		if (ModList.get().isLoaded(QuarkCompat.MODID)) {
			QuarkCompat.registerStorageScreens(event);
		} else {
			event.register(ModMenus.VASE.get(), StorageScreen<VaseMenu>::new);
			event.register(ModMenus.BARREL.get(), StorageScreen<RusticBarrelMenu>::new);
			event.register(ModMenus.CABINET.get(), StorageScreen<CabinetMenu>::new);
			event.register(ModMenus.CABINET_DOUBLE.get(), StorageScreen<DoubleCabinetMenu>::new);
		}
		event.register(ModMenus.APIARY.get(), ApiaryScreen::new);
	}

	private static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(CabinetModel.SINGLE, () -> CabinetModel.createSingle(false));
		event.registerLayerDefinition(CabinetModel.SINGLE_MIRROR, () -> CabinetModel.createSingle(true));
		event.registerLayerDefinition(CabinetModel.DOUBLE, () -> CabinetModel.createDouble(false));
		event.registerLayerDefinition(CabinetModel.DOUBLE_MIRROR, () -> CabinetModel.createDouble(true));
	}

	private static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerBlockEntityRenderer(ModBlockEntities.CABINET.get(), CabinetRenderer::new);
	}

	private static void registerClientExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private BlockEntityWithoutLevelRenderer renderer;

			@Override
			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
				// created on first use: the entity models are not baked yet when this event fires
				if (renderer == null) {
					renderer = new CabinetItemRenderer();
				}
				return renderer;
			}
		}, ModBlocks.CABINET.asItem());
	}

	private static void registerReloadListeners(RegisterClientReloadListenersEvent event) {
		event.registerReloadListener((ResourceManagerReloadListener) resourceManager -> MaterialColors.clear());
	}
}
