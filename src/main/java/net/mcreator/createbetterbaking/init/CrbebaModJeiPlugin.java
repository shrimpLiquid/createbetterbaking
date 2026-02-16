package net.mcreator.createbetterbaking.init;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import net.mcreator.createbetterbaking.recipe.BigBakingRecipe;
import net.mcreator.createbetterbaking.integration.jei.BigBakingJeiCategory;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;

@JeiPlugin
public class CrbebaModJeiPlugin implements IModPlugin {
	private static final String UID = "crbeba";
	public static RecipeType<RecipeHolder<BigBakingRecipe>> BIG_BAKING_JEI_CATEGORY = RecipeType.create(UID, "big_baking", (Class<RecipeHolder<BigBakingRecipe>>) (Class<?>) BigBakingRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.fromNamespaceAndPath(UID, "jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new BigBakingJeiCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		registration.addRecipes(BIG_BAKING_JEI_CATEGORY, recipeManager.getAllRecipesFor(BigBakingRecipe.Type.INSTANCE));
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
	}

	@Override
	public void registerGuiHandlers(IGuiHandlerRegistration registration) {
	}
}