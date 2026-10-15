package com.skd.rustichearth.datagen;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.datagen.providers.RusticAdvancementProvider;
import com.skd.rustichearth.datagen.providers.RusticBlockLoot;
import com.skd.rustichearth.datagen.providers.RusticBlockStateProvider;
import com.skd.rustichearth.datagen.providers.RusticDataMapProvider;
import com.skd.rustichearth.datagen.providers.RusticLanguageProvider;
import com.skd.rustichearth.datagen.providers.RusticLootModifierProvider;
import com.skd.rustichearth.datagen.providers.RusticRecipeProvider;
import com.skd.rustichearth.datagen.providers.RusticTagProviders;
import com.skd.rustichearth.datagen.providers.RusticWorldGenProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

/**
 * Data generation entry point ({@code gradlew runData}). Every provider lives in
 * {@code datagen.providers}; the per-subsystem content lives in {@code datagen.providers.parts}.
 */
@EventBusSubscriber(modid = RusticHearth.MODID)
public final class DataGenerators {
	private DataGenerators() {
	}

	@SubscribeEvent
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper helper = event.getExistingFileHelper();

		// datapack registries first: everything else looks them up
		RusticWorldGenProvider worldGen = generator.addProvider(event.includeServer(),
				new RusticWorldGenProvider(output, event.getLookupProvider()));
		CompletableFuture<HolderLookup.Provider> lookup = worldGen.getRegistryProvider();

		// client
		generator.addProvider(event.includeClient(), new RusticBlockStateProvider(output, helper));
		for (String locale : RusticLanguageProvider.LOCALES) {
			generator.addProvider(event.includeClient(), new RusticLanguageProvider(output, locale));
		}

		// server
		generator.addProvider(event.includeServer(), new RusticRecipeProvider(output, lookup));
		generator.addProvider(event.includeServer(), new LootTableProvider(output, Set.of(),
				List.of(new LootTableProvider.SubProviderEntry(RusticBlockLoot::new, LootContextParamSets.BLOCK)), lookup));
		RusticTagProviders.Blocks blockTags = generator.addProvider(event.includeServer(),
				new RusticTagProviders.Blocks(output, lookup, helper));
		generator.addProvider(event.includeServer(), new RusticTagProviders.Items(output, lookup, blockTags.contentsGetter(), helper));
		generator.addProvider(event.includeServer(), new RusticTagProviders.Fluids(output, lookup, helper));
		generator.addProvider(event.includeServer(), new RusticTagProviders.EntityTypes(output, lookup, helper));
		generator.addProvider(event.includeServer(), new RusticTagProviders.Biomes(output, lookup, helper));
		generator.addProvider(event.includeServer(), new RusticTagProviders.BannerPatterns(output, lookup, helper));
		generator.addProvider(event.includeServer(), new RusticDataMapProvider(output, lookup));
		generator.addProvider(event.includeServer(), new RusticLootModifierProvider(output, lookup));
		generator.addProvider(event.includeServer(), new RusticAdvancementProvider(output, lookup, helper));
	}
}
