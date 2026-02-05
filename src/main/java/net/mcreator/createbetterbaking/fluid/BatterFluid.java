package net.mcreator.createbetterbaking.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.createbetterbaking.init.CrbebaModItems;
import net.mcreator.createbetterbaking.init.CrbebaModFluids;
import net.mcreator.createbetterbaking.init.CrbebaModFluidTypes;
import net.mcreator.createbetterbaking.init.CrbebaModBlocks;

public abstract class BatterFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CrbebaModFluidTypes.BATTER_TYPE.get(), () -> CrbebaModFluids.BATTER.get(), () -> CrbebaModFluids.FLOWING_BATTER.get()).explosionResistance(100f)
			.tickRate(50).bucket(() -> CrbebaModItems.BATTER_BUCKET.get()).block(() -> (LiquidBlock) CrbebaModBlocks.BATTER.get());

	private BatterFluid() {
		super(PROPERTIES);
	}

	public static class Source extends BatterFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends BatterFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}