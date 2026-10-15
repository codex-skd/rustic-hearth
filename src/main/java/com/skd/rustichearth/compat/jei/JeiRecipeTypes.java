package com.skd.rustichearth.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import com.skd.rustichearth.RusticHearth;
import com.skd.rustichearth.recipe.BrewingRecipe;
import com.skd.rustichearth.recipe.CondenserRecipe;
import com.skd.rustichearth.recipe.CrushingTubRecipe;
import com.skd.rustichearth.recipe.EvaporatingBasinRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

/**
 * JEI recipe categories added by Rustic. Condenser recipes are split in two categories depending
 * on {@link CondenserRecipe#advanced()}.
 */
public final class JeiRecipeTypes {
	public static final RecipeType<RecipeHolder<CrushingTubRecipe>> CRUSHING_TUB = RecipeType.createRecipeHolderType(RusticHearth.id("crushing_tub"));
	public static final RecipeType<RecipeHolder<EvaporatingBasinRecipe>> EVAPORATING = RecipeType.createRecipeHolderType(RusticHearth.id("evaporating"));
	public static final RecipeType<RecipeHolder<CondenserRecipe>> SIMPLE_ALCHEMY = RecipeType.createRecipeHolderType(RusticHearth.id("simple_alchemy"));
	public static final RecipeType<RecipeHolder<CondenserRecipe>> ADVANCED_ALCHEMY = RecipeType.createRecipeHolderType(RusticHearth.id("advanced_alchemy"));
	public static final RecipeType<RecipeHolder<BrewingRecipe>> BREWING = RecipeType.createRecipeHolderType(RusticHearth.id("brewing"));

	private JeiRecipeTypes() {
	}
}
