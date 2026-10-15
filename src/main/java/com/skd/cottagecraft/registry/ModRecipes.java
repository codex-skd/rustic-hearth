package com.skd.cottagecraft.registry;

import com.mojang.serialization.MapCodec;

import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.recipe.BrewingRecipe;
import com.skd.cottagecraft.recipe.CabinetRecipe;
import com.skd.cottagecraft.recipe.CondenserRecipe;
import com.skd.cottagecraft.recipe.ConfigCondition;
import com.skd.cottagecraft.recipe.CrushingTubRecipe;
import com.skd.cottagecraft.recipe.EvaporatingBasinRecipe;
import com.skd.cottagecraft.recipe.NoRemainderShapelessRecipe;
import com.skd.cottagecraft.recipe.OliveOilRecipe;
import com.skd.cottagecraft.recipe.VantaOilRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.SimpleCraftingRecipeSerializer;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public final class ModRecipes {
	public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(Registries.RECIPE_TYPE, Cottagecraft.NAMESPACE);
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(Registries.RECIPE_SERIALIZER, Cottagecraft.NAMESPACE);
	public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITIONS = DeferredRegister.create(NeoForgeRegistries.Keys.CONDITION_CODECS, Cottagecraft.NAMESPACE);

	public static final DeferredHolder<RecipeType<?>, RecipeType<CrushingTubRecipe>> CRUSHING_TUB = type("crushing_tub");
	public static final DeferredHolder<RecipeType<?>, RecipeType<EvaporatingBasinRecipe>> EVAPORATING_BASIN = type("evaporating_basin");
	public static final DeferredHolder<RecipeType<?>, RecipeType<CondenserRecipe>> CONDENSER = type("condenser");
	public static final DeferredHolder<RecipeType<?>, RecipeType<BrewingRecipe>> BREWING = type("brewing");

	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CrushingTubRecipe>> CRUSHING_TUB_SERIALIZER =
			serializer("crushing_tub", CrushingTubRecipe.CODEC, CrushingTubRecipe.STREAM_CODEC);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<EvaporatingBasinRecipe>> EVAPORATING_BASIN_SERIALIZER =
			serializer("evaporating_basin", EvaporatingBasinRecipe.CODEC, EvaporatingBasinRecipe.STREAM_CODEC);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CondenserRecipe>> CONDENSER_SERIALIZER =
			serializer("condenser", CondenserRecipe.CODEC, CondenserRecipe.STREAM_CODEC);
	public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<BrewingRecipe>> BREWING_SERIALIZER =
			serializer("brewing", BrewingRecipe.CODEC, BrewingRecipe.STREAM_CODEC);
	public static final DeferredHolder<RecipeSerializer<?>, NoRemainderShapelessRecipe.Serializer> NO_REMAINDER_SHAPELESS_SERIALIZER =
			SERIALIZERS.register("shapeless_no_remainder", NoRemainderShapelessRecipe.Serializer::new);
	public static final DeferredHolder<RecipeSerializer<?>, SimpleCraftingRecipeSerializer<OliveOilRecipe>> OLIVE_OIL_SERIALIZER =
			SERIALIZERS.register("olive_oil", () -> new SimpleCraftingRecipeSerializer<>(OliveOilRecipe::new));
	public static final DeferredHolder<RecipeSerializer<?>, SimpleCraftingRecipeSerializer<VantaOilRecipe>> VANTA_OIL_SERIALIZER =
			SERIALIZERS.register("vanta_oil", () -> new SimpleCraftingRecipeSerializer<>(VantaOilRecipe::new));
	public static final DeferredHolder<RecipeSerializer<?>, SimpleCraftingRecipeSerializer<CabinetRecipe>> CABINET_SERIALIZER =
			SERIALIZERS.register("cabinet", () -> new SimpleCraftingRecipeSerializer<>(CabinetRecipe::new));

	public static final DeferredHolder<MapCodec<? extends ICondition>, MapCodec<ConfigCondition>> CONFIG_CONDITION =
			CONDITIONS.register("config", () -> ConfigCondition.CODEC);

	private ModRecipes() {
	}

	private static <T extends Recipe<?>> DeferredHolder<RecipeType<?>, RecipeType<T>> type(String name) {
		return TYPES.register(name, () -> RecipeType.simple(Cottagecraft.id(name)));
	}

	private static <T extends Recipe<?>> DeferredHolder<RecipeSerializer<?>, RecipeSerializer<T>> serializer(String name, MapCodec<T> codec,
			StreamCodec<RegistryFriendlyByteBuf, T> streamCodec) {
		return SERIALIZERS.register(name, () -> new RecipeSerializer<>() {
			@Override
			public MapCodec<T> codec() {
				return codec;
			}

			@Override
			public StreamCodec<RegistryFriendlyByteBuf, T> streamCodec() {
				return streamCodec;
			}
		});
	}
}
