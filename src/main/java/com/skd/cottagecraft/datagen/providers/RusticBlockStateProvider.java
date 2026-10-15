package com.skd.cottagecraft.datagen.providers;

import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.datagen.providers.parts.AlchemyData;
import com.skd.cottagecraft.datagen.providers.parts.DecorData;
import com.skd.cottagecraft.datagen.providers.parts.FarmData;
import com.skd.cottagecraft.datagen.providers.parts.MiscData;
import com.skd.cottagecraft.datagen.providers.parts.StorageData;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

/**
 * Block states, block models and item models ({@link #itemModels()}).
 * Each subsystem generates its own entries from {@code datagen.parts}.
 */
public class RusticBlockStateProvider extends BlockStateProvider {
	private final ExistingFileHelper existingFileHelper;

	public RusticBlockStateProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
		super(output, Cottagecraft.NAMESPACE, existingFileHelper);
		this.existingFileHelper = existingFileHelper;
	}

	@Override
	protected void registerStatesAndModels() {
		DecorData.blockStates(this);
		FarmData.blockStates(this);
		StorageData.blockStates(this);
		AlchemyData.blockStates(this);
		MiscData.blockStates(this);
	}

	public ExistingFileHelper fileHelper() {
		return existingFileHelper;
	}

	// ---------------------------------------------------------------- helpers shared by the parts

	public String name(Block block) {
		return key(block).getPath();
	}

	public ResourceLocation key(Block block) {
		return net.minecraft.core.registries.BuiltInRegistries.BLOCK.getKey(block);
	}

	/** {@code cottagecraft:block/<path>} */
	public ResourceLocation blockTex(String path) {
		return Cottagecraft.id("block/" + path);
	}

	/** Item model that just points at the block model {@code cottagecraft:block/<model>}. */
	public ItemModelBuilder blockItem(Block block, String model) {
		return itemModels().withExistingParent(name(block), Cottagecraft.id("block/" + model));
	}

	/** Item model that just points at the block model of the same name. */
	public ItemModelBuilder blockItem(Block block) {
		return blockItem(block, name(block));
	}

	/** Flat item model with texture {@code cottagecraft:<texture>}. */
	public ItemModelBuilder generatedItem(String name, String texture) {
		return itemModels().withExistingParent(name, mcLoc("item/generated")).texture("layer0", Cottagecraft.id(texture));
	}
}
