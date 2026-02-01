/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.createbetterbaking.CrbebaMod;

public class CrbebaModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CrbebaMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATE_BETTER_BAKING = REGISTRY.register("create_better_baking",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.crbeba.create_better_baking")).icon(() -> new ItemStack(CrbebaModBlocks.CAKE_PAN_WITH_CAKE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(CrbebaModBlocks.CAKE_PAN_WITH_CAKE.get().asItem());
				tabData.accept(CrbebaModBlocks.CAKE_PAN_WITH_BATTER.get().asItem());
				tabData.accept(CrbebaModBlocks.CAKE_PAN.get().asItem());
			}).build());
}