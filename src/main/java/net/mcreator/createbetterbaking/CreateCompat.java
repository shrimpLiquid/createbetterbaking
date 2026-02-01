package net.mcreator.createbetterbaking;

import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import com.simibubi.create.content.fluids.spout.SpoutBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.registries.RegisterEvent;

public class CreateCompat {

    static {
        System.out.println("DEBUG: CreateCompat class has been loaded into memory!");
    }

    public static void init(IEventBus modBus) {
        System.out.println("DEBUG: CreateCompat.init() called. Adding listener...");
        modBus.addListener(CreateCompat::onRegister);
    }

    public static void onRegister(RegisterEvent event) {
        // Manually creating the key to bypass version-specific variable names
        ResourceKey<net.minecraft.core.Registry<BlockSpoutingBehaviour>> spoutKey = 
            ResourceKey.createRegistryKey(ResourceLocation.fromNamespaceAndPath("create", "spouting_behaviour"));

        event.register(spoutKey, helper -> {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath("createbetterbaking", "spout_hydration");

            BlockSpoutingBehaviour hydrationBehaviour = new BlockSpoutingBehaviour() {
                @Override
                public int fillBlock(Level level, BlockPos pos, SpoutBlockEntity spout, FluidStack fluidStack, boolean simulate) {
                    // Check 1 and 2 blocks below the Spout
                    for (int i = 1; i <= 2; i++) {
                        BlockPos targetPos = pos.below(i);
                        BlockState currentState = level.getBlockState(targetPos);

                        if (fluidStack.getFluid().isSame(Fluids.WATER) && fluidStack.getAmount() >= 100) {
                            if (currentState.is(Blocks.SAND)) {
                                if (!simulate) {
                                    System.out.println("SPOUT SUCCESS: Converting sand to grass!");
                                    level.setBlockAndUpdate(targetPos, Blocks.GRASS_BLOCK.defaultBlockState());
                                }
                                return 100;
                            }
                        }
                    }
                    return 0;
                }
            };

            helper.register(id, hydrationBehaviour);
            System.out.println("DEBUG: Spout Behavior 'spout_hydration' Registered!");
        });
    }
}