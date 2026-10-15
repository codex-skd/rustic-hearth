package com.skd.cottagecraft;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import com.skd.cottagecraft.config.RusticConfig;
import com.skd.cottagecraft.network.RusticNetwork;
import com.skd.cottagecraft.registry.ModBlockEntities;
import com.skd.cottagecraft.registry.ModBlocks;
import com.skd.cottagecraft.registry.ModCreativeTabs;
import com.skd.cottagecraft.registry.ModCriteria;
import com.skd.cottagecraft.registry.ModDataComponents;
import com.skd.cottagecraft.registry.ModEffects;
import com.skd.cottagecraft.registry.ModEntities;
import com.skd.cottagecraft.registry.ModFluids;
import com.skd.cottagecraft.registry.ModItems;
import com.skd.cottagecraft.registry.ModMenus;
import com.skd.cottagecraft.registry.ModRecipes;
import com.skd.cottagecraft.registry.ModWorldGen;
import com.skd.cottagecraft.setup.CommonSetup;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

/**
 * Cottagecraft: a rustic cottage-core mod of decoration, agriculture, brewing and alchemy.
 * A fork of Rustic Revived, itself a NeoForge port of Rustic (1.12.2).
 * <p>
 * The mod id is {@value #MODID}; every registry entry, asset and data file lives in the same
 * {@value #NAMESPACE} namespace.
 */
@Mod(Cottagecraft.MODID)
public class Cottagecraft {
	/** Mod id (mods.toml, events, configs). */
	public static final String MODID = "cottagecraft";
	/** Namespace of every registry entry, asset and data file. */
	public static final String NAMESPACE = "cottagecraft";
	public static final Logger LOGGER = LogUtils.getLogger();

	public Cottagecraft(IEventBus modBus, ModContainer container) {
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
