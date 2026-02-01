package net.mcreator.createbetterbaking;

// Dangerous imports are safe here because this class is ONLY loaded 
// if we explicitly call it after checking if Create is loaded.
import com.simibubi.create.api.behavior.SpoutAction;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class CreateCompat {
    public static void registerSpoutInteractions() {
        SpoutAction.register(new ResourceLocation("createbetterbaking", "world_block_hydration"), (level, pos, spout, fluidStack, itemStack, simulate) -> {
            BlockPos targetPos = pos.below(2);
            BlockState currentState = level.getBlockState(targetPos);

            if (!fluidStack.getFluid().isSame(Fluids.WATER) || fluidStack.getAmount() < 100) return 0;
            if (!currentState.is(Blocks.DIRT)) return 0;
            if (simulate) return 100;

            level.setBlockAndUpdate(targetPos, Blocks.GRASS_BLOCK.defaultBlockState());
            return 100;
        });
    }
}
