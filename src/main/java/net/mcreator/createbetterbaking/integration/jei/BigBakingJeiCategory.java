package net.mcreator.createbetterbaking.integration.jei;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.createbetterbaking.recipe.RecipeUtils;
import net.mcreator.createbetterbaking.recipe.BigBakingRecipe;
import net.mcreator.createbetterbaking.init.CrbebaModJeiPlugin;

import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class BigBakingJeiCategory extends AbstractJeiCategory<RecipeHolder<BigBakingRecipe>> {
	public BigBakingJeiCategory(IGuiHelper helper) {
		super(CrbebaModJeiPlugin.BIG_BAKING_JEI_CATEGORY, "jei.crbeba.big_baking", helper.createDrawable(ResourceLocation.parse("crbeba:textures/screens/test.png"), 0, 0, 185, 78),
				helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(Blocks.BAMBOO_MOSAIC)));
	}

	@Override
	public void draw(RecipeHolder<BigBakingRecipe> recipe, GuiGraphics guiGraphics, double mouseX, double mouseY) {
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<BigBakingRecipe> recipe) {
		builder.addSlot(RecipeIngredientRole.INPUT, 0, 0).addIngredients(VanillaTypes.ITEM_STACK, RecipeUtils.getItemStacks(recipe.value().blockItemInput()));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 20, 30).addItemStack(recipe.value().getItemStackResult("new"));
	}
}