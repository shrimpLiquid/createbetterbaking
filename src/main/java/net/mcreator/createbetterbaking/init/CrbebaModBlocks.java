/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.createbetterbaking.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.Block;

import net.mcreator.createbetterbaking.block.*;
import net.mcreator.createbetterbaking.CrbebaMod;

public class CrbebaModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(CrbebaMod.MODID);
	public static final DeferredBlock<Block> CAKE_PAN_WITH_CAKE;
	public static final DeferredBlock<Block> CAKE_PAN_WITH_BATTER;
	public static final DeferredBlock<Block> CAKE_PAN;
	public static final DeferredBlock<Block> UNFROSTED_CAKE;
	public static final DeferredBlock<Block> FROSTING;
	public static final DeferredBlock<Block> BATTER;
	static {
		CAKE_PAN_WITH_CAKE = REGISTRY.register("cake_pan_with_cake", CakePanWithCakeBlock::new);
		CAKE_PAN_WITH_BATTER = REGISTRY.register("cake_pan_with_batter", CakePanWithBatterBlock::new);
		CAKE_PAN = REGISTRY.register("cake_pan", CakePanBlock::new);
		UNFROSTED_CAKE = REGISTRY.register("unfrosted_cake", UnfrostedCakeBlock::new);
		FROSTING = REGISTRY.register("frosting", FrostingBlock::new);
		BATTER = REGISTRY.register("batter", BatterBlock::new);
	}
	// Start of user code block custom blocks
	// End of user code block custom blocks
}