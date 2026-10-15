package com.skd.rustichearth.world.placement;

import com.mojang.serialization.MapCodec;

import com.skd.rustichearth.registry.ModWorldGen;
import com.skd.rustichearth.world.WorldGenOptions;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementContext;
import net.minecraft.world.level.levelgen.placement.PlacementFilter;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;

/**
 * Passes with the probability of a Rustic config chance, read at generation time.
 *
 * <pre>{"type": "rustic_hearth:config_chance", "option": "oliveGenChance"}</pre>
 */
public class ConfigChancePlacement extends PlacementFilter {
	public static final MapCodec<ConfigChancePlacement> CODEC = WorldGenOptions.CHANCE.fieldOf("option")
			.xmap(ConfigChancePlacement::new, placement -> placement.option);

	private final String option;

	public ConfigChancePlacement(String option) {
		this.option = option;
	}

	@Override
	protected boolean shouldPlace(PlacementContext context, RandomSource random, BlockPos pos) {
		return random.nextFloat() < WorldGenOptions.chance(option);
	}

	@Override
	public PlacementModifierType<?> type() {
		return ModWorldGen.CONFIG_CHANCE.get();
	}
}
