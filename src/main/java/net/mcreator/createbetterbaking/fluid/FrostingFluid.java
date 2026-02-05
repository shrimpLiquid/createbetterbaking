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

public abstract class FrostingFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> CrbebaModFluidTypes.FROSTING_TYPE.get(), () -> CrbebaModFluids.FROSTING.get(), () -> CrbebaModFluids.FLOWING_FROSTING.get())
			.explosionResistance(100f).tickRate(50).bucket(() -> CrbebaModItems.FROSTING_BUCKET.get()).block(() -> (LiquidBlock) CrbebaModBlocks.FROSTING.get());

	private FrostingFluid() {
		super(PROPERTIES);
	}

	public static class Source extends FrostingFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends FrostingFluid {
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