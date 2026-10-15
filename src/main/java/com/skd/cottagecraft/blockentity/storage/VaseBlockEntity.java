package com.skd.cottagecraft.blockentity.storage;

import com.skd.cottagecraft.menu.storage.VaseMenu;
import com.skd.cottagecraft.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Vase inventory, 27 slots (legacy TileEntityVase).
 */
public class VaseBlockEntity extends StorageBlockEntity {
	public VaseBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.VASE.get(), pos, state);
	}

	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.cottagecraft.vase");
	}

	@Override
	protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
		return new VaseMenu(containerId, inventory, this);
	}
}
