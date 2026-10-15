package com.skd.cottagecraft.advancement;

import java.util.Optional;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import com.skd.cottagecraft.fluid.BoozeFluidType;
import com.skd.cottagecraft.registry.ModDataComponents;
import net.minecraft.advancements.critereon.ItemSubPredicate;
import net.minecraft.advancements.critereon.MinMaxBounds;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.FluidUtil;
import net.neoforged.neoforge.fluids.SimpleFluidContent;

/**
 * Item sub predicate {@code cottagecraft:booze} (legacy AlcoholItemPredicate {@code rustic:alcohol}):
 * matches containers (fluid bottles, liquid barrels, ...) holding a booze, optionally of one specific
 * fluid, whose quality is within the given bounds.
 * <pre>{@code "predicates": { "cottagecraft:booze": { "fluid": "cottagecraft:wine", "quality": { "min": 0.999 } } }}</pre>
 */
public record BoozeItemPredicate(Optional<Holder<Fluid>> fluid, MinMaxBounds.Doubles quality) implements ItemSubPredicate {
	public static final Codec<BoozeItemPredicate> CODEC = RecordCodecBuilder.create(i -> i.group(
			BuiltInRegistries.FLUID.holderByNameCodec().optionalFieldOf("fluid").forGetter(BoozeItemPredicate::fluid),
			MinMaxBounds.Doubles.CODEC.optionalFieldOf("quality", MinMaxBounds.Doubles.ANY).forGetter(BoozeItemPredicate::quality)
	).apply(i, BoozeItemPredicate::new));

	/** Any booze of at least {@code minQuality}. */
	public static BoozeItemPredicate minQuality(double minQuality) {
		return new BoozeItemPredicate(Optional.empty(), MinMaxBounds.Doubles.atLeast(minQuality));
	}

	/** The given booze with a quality of at least {@code minQuality}. */
	public static BoozeItemPredicate minQuality(Fluid fluid, double minQuality) {
		return new BoozeItemPredicate(Optional.of(fluid.builtInRegistryHolder()), MinMaxBounds.Doubles.atLeast(minQuality));
	}

	@Override
	public boolean matches(ItemStack stack) {
		if (stack.isEmpty()) return false;
		FluidStack contained = FluidUtil.getFluidContained(stack)
				.orElseGet(() -> stack.getOrDefault(ModDataComponents.FLUID, SimpleFluidContent.EMPTY).copy());
		if (contained.isEmpty() || !(contained.getFluidType() instanceof BoozeFluidType)) return false;
		if (fluid.isPresent() && !contained.is(fluid.get())) return false;
		return quality.matches(BoozeFluidType.getQuality(contained));
	}
}
