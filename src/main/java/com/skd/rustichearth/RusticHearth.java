package com.skd.rustichearth;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import com.skd.rustichearth.config.RusticConfig;
import com.skd.rustichearth.network.RusticNetwork;
import com.skd.rustichearth.registry.ModBlockEntities;
import com.skd.rustichearth.registry.ModBlocks;
import com.skd.rustichearth.registry.ModCreativeTabs;
import com.skd.rustichearth.registry.ModCriteria;
import com.skd.rustichearth.registry.ModDataComponents;
import com.skd.rustichearth.registry.ModEffects;
import com.skd.rustichearth.registry.ModEntities;
import com.skd.rustichearth.registry.ModFluids;
import com.skd.rustichearth.registry.ModItems;
import com.skd.rustichearth.registry.ModMenus;
import com.skd.rustichearth.registry.ModRecipes;
import com.skd.rustichearth.registry.ModWorldGen;
import com.skd.rustichearth.setup.CommonSetup;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

/**
 * RusticHearth: a rustic cottage-core mod of decoration, agriculture, brewing and alchemy.
 * A fork of Rustic Revived, itself a NeoForge port of Rustic (1.12.2).
 * <p>
 * The mod id is {@value #MODID}; every registry entry, asset and data file lives in the same
 * {@value #NAMESPACE} namespace.
 */
@Mod(RusticHearth.MODID)
public class RusticHearth {
	/** Mod id (mods.toml, events, configs). */
	public static final String MODID = "rustic_hearth";
	/** Namespace of every registry entry, asset and data file. */
	public static final String NAMESPACE = "rustic_hearth";
	public static final Logger LOGGER = LogUtils.getLogger();

	public RusticHearth(IEventBus modBus, ModContainer container) {
		// fluids first: they add their liquid blocks and buckets to the block / item registers
		ModFluids.FLUID_TYPES.register(modBus);
		ModFluids.FLUIDS.register(modBus);
		ModBlocks.BLOCKS.register(modBus);
		ModItems.ITEMS.register(modBus);
		ModBlockEntities.BLOCK_ENTITIES.register(modBus);
		ModMenus.MENUS.register(modBus);
		ModEntities.ENTITIES.register(modBus);
		ModEffects.EFFECTS.register(modBus);
		ModDataComponents.COMPONENTS.register(modBus);
		ModRecipes.TYPES.register(modBus);
		ModRecipes.SERIALIZERS.register(modBus);
		ModRecipes.CONDITIONS.register(modBus);
		ModCreativeTabs.TABS.register(modBus);
		ModWorldGen.register(modBus);
		ModCriteria.TRIGGERS.register(modBus);

		container.registerConfig(ModConfig.Type.COMMON, RusticConfig.COMMON_SPEC);
		container.registerConfig(ModConfig.Type.CLIENT, RusticConfig.CLIENT_SPEC);

		modBus.addListener(RusticNetwork::register);
		CommonSetup.init(modBus);
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(NAMESPACE, path);
	}
}
