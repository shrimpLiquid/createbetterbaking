package net.mcreator.createbetterbaking;


import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.FluidStack;
import net.mcreator.createbetterbaking.init.CrbebaModBlocks;
import com.simibubi.create.api.behaviour.spouting.BlockSpoutingBehaviour;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.tags.BlockTags;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.mcreator.createbetterbaking.init.CrbebaModFluids;

public class CreateCompatS {

    public static void init(IEventBus modBus) {
        // We use CommonSetup to ensure Create's registries are initialized first
        modBus.addListener(CreateCompatS::onCommonSetup);
    }

    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            BlockSpoutingBehaviour sandBehavior = (level, pos, spout, fluidStack, simulate) -> {
                // 1. Check for Water
                if (!fluidStack.getFluid().isSame(CrbebaModFluids.BATTER.get())) {
                    return 0;
                }

                // 2. Check if the block is Sand (or Red Sand)
                if (level.getBlockState(pos).is(CrbebaModBlocks.CAKE_PAN.get()) ) {
                	if (level.getBlockState(pos).getValue(net.minecraft.world.level.block.state.properties.BlockStateProperties.FACING) == Direction.UP) {
                    if (simulate) return 500;

                    // 3. Transform the block
                    level.setBlockAndUpdate(pos,  CrbebaModBlocks.CAKE_PAN_WITH_BATTER.get().defaultBlockState());
                    return 500;
                }}
                return 0;
            };

            // This is the specific "BY_BLOCK" registry found in your file
            BlockSpoutingBehaviour.BY_BLOCK.register(CrbebaModBlocks.CAKE_PAN.get(), sandBehavior);
            
            
            System.out.println("!!! CRBEBA: Sand Spouting logic injected into Create's BY_BLOCK registry!");
        });
    }
}