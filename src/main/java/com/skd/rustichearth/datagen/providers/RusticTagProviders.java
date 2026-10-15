package com.skd.rustichearth.datagen.providers;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.datagen.providers.parts.AlchemyData;
import com.skd.rustichearth.datagen.providers.parts.DecorData;
import com.skd.rustichearth.datagen.providers.parts.FarmData;
import com.skd.rustichearth.datagen.providers.parts.MiscData;
import com.skd.rustichearth.datagen.providers.parts.StorageData;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BannerPattern;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * All tag providers. The {@code tagOf} methods re-expose the protected {@code tag} builders so the
 * subsystem parts in {@code datagen.providers.parts} can fill them.
 */
public final class RusticTagProviders {
	private RusticTagProviders() {
	}

	public static class Blocks extends BlockTagsProvider {
		public Blocks(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
			super(output, lookup, RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			DecorData.blockTags(this);
			FarmData.blockTags(this);
			StorageData.blockTags(this);
			AlchemyData.blockTags(this);
			MiscData.blockTags(this);
		}

		public IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block> tagOf(TagKey<Block> tag) {
			return tag(tag);
		}
	}

	public static class Items extends ItemTagsProvider {
		public Items(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup,
				CompletableFuture<TagLookup<Block>> blockTags, @Nullable ExistingFileHelper helper) {
			super(output, lookup, blockTags, RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			DecorData.itemTags(this);
			FarmData.itemTags(this);
			StorageData.itemTags(this);
			AlchemyData.itemTags(this);
			MiscData.itemTags(this);
		}

		public IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item> tagOf(TagKey<Item> tag) {
			return tag(tag);
		}

		/** Copies a block tag into the item tag of the same name. */
		public void copyTag(TagKey<Block> blockTag, TagKey<Item> itemTag) {
			copy(blockTag, itemTag);
		}
	}

	public static class Fluids extends IntrinsicHolderTagsProvider<Fluid> {
		public Fluids(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
			super(output, Registries.FLUID, lookup, f -> f.builtInRegistryHolder().key(), RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			AlchemyData.fluidTags(this);
			MiscData.fluidTags(this);
		}

		public IntrinsicHolderTagsProvider.IntrinsicTagAppender<Fluid> tagOf(TagKey<Fluid> tag) {
			return tag(tag);
		}
	}

	public static class EntityTypes extends IntrinsicHolderTagsProvider<EntityType<?>> {
		public EntityTypes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
			super(output, Registries.ENTITY_TYPE, lookup, e -> e.builtInRegistryHolder().key(), RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			MiscData.entityTypeTags(this);
		}

		public IntrinsicHolderTagsProvider.IntrinsicTagAppender<EntityType<?>> tagOf(TagKey<EntityType<?>> tag) {
			return tag(tag);
		}
	}

	public static class Biomes extends TagsProvider<Biome> {
		public Biomes(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
			super(output, Registries.BIOME, lookup, RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			FarmData.biomeTags(this);
		}

		public TagsProvider.TagAppender<Biome> tagOf(TagKey<Biome> tag) {
			return tag(tag);
		}
	}

	public static class BannerPatterns extends TagsProvider<BannerPattern> {
		public BannerPatterns(PackOutput output, CompletableFuture<HolderLookup.Provider> lookup, @Nullable ExistingFileHelper helper) {
			super(output, Registries.BANNER_PATTERN, lookup, RusticHearth.NAMESPACE, helper);
		}

		@Override
		protected void addTags(HolderLookup.Provider provider) {
			MiscData.bannerPatternTags(this);
		}

		public TagsProvider.TagAppender<BannerPattern> tagOf(TagKey<BannerPattern> tag) {
			return tag(tag);
		}
	}
}
