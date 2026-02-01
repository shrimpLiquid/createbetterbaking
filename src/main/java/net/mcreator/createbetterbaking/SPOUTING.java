package net.mcreator.createbetterbaking;

import com.simibubi.create.api.behavior.SpoutAction;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;

public class WorldBlockSpoutInteraction {

    public static void register() {
        SpoutAction.register(new ResourceLocation("createbetterbaking", "world_block_hydration"), (level, pos, spout, fluidStack, itemStack, simulate) -> {
            
            // 1. Identify the target position (usually 2 blocks below the Spout)
            BlockPos targetPos = pos.below(2);
            BlockState currentState = level.getBlockState(targetPos);

            // 2. Requirements: Fluid (Water) and World Block (Dirt)
            if (!fluidStack.getFluid().isSame(Fluids.WATER) || fluidStack.getAmount() < 100) {
                return 0;
            }

            if (!currentState.is(Blocks.DIRT)) {
                return 0;
            }

            // 3. Handle Simulation
            if (simulate) {
                return 100;
            }

            // 4. Change the block in the world
            // We set the block at targetPos to Grass
            level.setBlockAndUpdate(targetPos, Blocks.GRASS_BLOCK.defaultBlockState());

            // Return fluid consumed
            return 100;
        });
    }
}