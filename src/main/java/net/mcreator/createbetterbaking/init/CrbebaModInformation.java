package net.mcreator.createbetterbaking.init;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.List;

@JeiPlugin
public class CrbebaModInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return ResourceLocation.parse("crbeba:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(CrbebaModBlocks.CAKE_PAN_WITH_CAKE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.crbeba.bakeinfo"));
		registration.addIngredientInfo(List.of(new ItemStack(CrbebaModBlocks.CAKE_PAN_WITH_BATTER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.crbeba.fillinfo"));
		registration.addIngredientInfo(List.of(new ItemStack(Items.CAKE)), VanillaTypes.ITEM_STACK, Component.translatable("jei.crbeba.frinfoostr"));
	}
}