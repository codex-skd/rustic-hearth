package com.skd.rustichearth.blockentity.storage;

import com.skd.rustichearth.menu.storage.RusticBarrelMenu;
import com.skd.rustichearth.registry.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Barrel inventory, 27 slots (legacy TileEntityBarrel).
 */
public class RusticBarrelBlockEntity extends StorageBlockEntity {
	public RusticBarrelBlockEntity(BlockPos pos, BlockState state) {
		super(ModBlockEntities.BARREL.get(), pos, state);
	}

	@Override
	protected Component getDefaultName() {
		return Component.translatable("container.rustic_hearth.barrel");
	}

	@Override
	protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
		return new RusticBarrelMenu(containerId, inventory, this);
	}
}
