package com.skd.cottagecraft.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import com.skd.cottagecraft.Cottagecraft;
import com.skd.cottagecraft.recipe.BrewingRecipe;
import com.skd.cottagecraft.recipe.CondenserRecipe;
import com.skd.cottagecraft.recipe.CrushingTubRecipe;
import com.skd.cottagecraft.recipe.EvaporatingBasinRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;

/**
 * JEI recipe categories added by Rustic. Condenser recipes are split in two categories depending
 * on {@link CondenserRecipe#advanced()}.
 */
public final class JeiRecipeTypes {
	public static final RecipeType<RecipeHolder<CrushingTubRecipe>> CRUSHING_TUB = RecipeType.createRecipeHolderType(Cottagecraft.id("crushing_tub"));
	public static final RecipeType<RecipeHolder<EvaporatingBasinRecipe>> EVAPORATING = RecipeType.createRecipeHolderType(Cottagecraft.id("evaporating"));
	public static final RecipeType<RecipeHolder<CondenserRecipe>> SIMPLE_ALCHEMY = RecipeType.createRecipeHolderType(Cottagecraft.id("simple_alchemy"));
	public static final RecipeType<RecipeHolder<CondenserRecipe>> ADVANCED_ALCHEMY = RecipeType.createRecipeHolderType(Cottagecraft.id("advanced_alchemy"));
	public static final RecipeType<RecipeHolder<BrewingRecipe>> BREWING = RecipeType.createRecipeHolderType(Cottagecraft.id("brewing"));

	private JeiRecipeTypes() {
	}
}
