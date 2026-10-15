package com.skd.cottagecraft.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.item.CreativeModeTab;

/**
 * Hook for creative tab entries that need generated stacks (filled fluid bottles, filled liquid
 * barrels, elixirs). Subsystems append generators here from their static initialisers or from
 * {@code Cottagecraft}'s constructor.
 */
public final class RusticCreativeContents {
	public static final List<CreativeModeTab.DisplayItemsGenerator> ALCHEMY_EXTRAS = new ArrayList<>();

	private RusticCreativeContents() {
	}
}
