package com.skd.cottagecraft.world.placement;

import com.mojang.serialization.MapCodec;

import com.skd.cottagecraft.registry.ModWorldGen;
import com.skd.cottagecraft.world.WorldGenOptions;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.placement.PlacementModifierType;
import net.minecraft.world.level.levelgen.placement.RepeatingPlacement;

/**
 * Repeats the placement as many times as a Rustic config value, read at generation time.
 *
 * <pre>{"type": "cottagecraft:config_count", "option": "maxOliveGenAttempts"}</pre>
 */
public class ConfigCountPlacement extends RepeatingPlacement {
	public static final MapCodec<ConfigCountPlacement> CODEC = WorldGenOptions.COUNT.fieldOf("option")
			.xmap(ConfigCountPlacement::new, placement -> placement.option);

	private final String option;

	public ConfigCountPlacement(String option) {
		this.option = option;
	}

	@Override
	protected int count(RandomSource random, BlockPos pos) {
		return WorldGenOptions.count(option);
	}

	@Override
	public PlacementModifierType<?> type() {
		return ModWorldGen.CONFIG_COUNT.get();
	}
}
