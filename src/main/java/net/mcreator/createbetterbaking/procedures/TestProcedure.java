package net.mcreator.createbetterbaking.procedures;

import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.createbetterbaking.init.CrbebaModFluids;
import net.mcreator.createbetterbaking.init.CrbebaModBlocks;

public class TestProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(BlockPos.containing(x, y, z), CrbebaModBlocks.CAKE_PAN_WITH_BATTER.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z), (world.getBlockState(BlockPos.containing(x, y, z))), 3);
		if (world instanceof ILevelExtension _ext) {
			IFluidHandler _fluidHandler = _ext.getCapability(Capabilities.FluidHandler.BLOCK, BlockPos.containing(x, y, z), null);
			if (_fluidHandler != null)
				_fluidHandler.fill(new FluidStack(CrbebaModFluids.BATTER.get(), 100), IFluidHandler.FluidAction.EXECUTE);
		}
	}
}