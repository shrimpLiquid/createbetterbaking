/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.createbetterbaking.CrbebaMod;

public class CrbebaModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(CrbebaMod.MODID);
	public static final DeferredItem<Item> CAKE_PAN_WITH_CAKE;
	public static final DeferredItem<Item> CAKE_PAN_WITH_BATTER;
	public static final DeferredItem<Item> CAKE_PAN;
	public static final DeferredItem<Item> UNFROSTED_CAKE;
	static {
		CAKE_PAN_WITH_CAKE = block(CrbebaModBlocks.CAKE_PAN_WITH_CAKE);
		CAKE_PAN_WITH_BATTER = block(CrbebaModBlocks.CAKE_PAN_WITH_BATTER);
		CAKE_PAN = block(CrbebaModBlocks.CAKE_PAN);
		UNFROSTED_CAKE = block(CrbebaModBlocks.UNFROSTED_CAKE);
	}

	// Start of user code block custom items
	// End of user code block custom items
	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), properties));
	}
}