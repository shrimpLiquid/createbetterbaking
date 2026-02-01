package net.mcreator.createbetterbaking.block;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty; // Added
import net.minecraft.world.level.block.state.properties.BlockStateProperties; // Added
import net.minecraft.world.level.block.state.StateDefinition; // Added
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DirectionalBlock; // Added
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext; // Added
import net.minecraft.core.Direction; // Added
import net.minecraft.core.BlockPos;
import net.mcreator.createbetterbaking.procedures.CakePanBlockAddedProcedure;

public class CakePanWithCakeBlock extends Block {
    // 1. Define the FACING property so the block knows which way it's looking
    public static final DirectionProperty FACING = DirectionalBlock.FACING;

    public CakePanWithCakeBlock() {
        super(BlockBehaviour.Properties.of()
            .sound(SoundType.METAL)
            .strength(5f, 10f)
            .noOcclusion()
            .isRedstoneConductor((bs, br, bp) -> false)
            .instrument(NoteBlockInstrument.BELL));
        
        // 2. Set the default state
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }
	@Override
	public void onPlace(BlockState blockstate, Level world, BlockPos pos, BlockState oldState, boolean moving) {
		super.onPlace(blockstate, world, pos, oldState, moving);
		world.scheduleTick(pos, this, 1);
		CakePanBlockAddedProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), blockstate);
	}
    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        // 3. This tells the block to face the side you clicked on
        return this.defaultBlockState().setValue(FACING, context.getClickedFace());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        // 4. This switches the HITBOX based on the direction. 
        // Note: You need to adjust these box numbers to match your specific model!
        return switch (state.getValue(FACING)) {
            case DOWN  -> box(0, 8, 0, 16, 16, 16); // Ceiling
            case UP    -> box(0, 0, 0, 16, 8, 16);  // Floor
            case NORTH -> box(0, 0, 8, 16, 16, 16); // Wall
            case SOUTH -> box(0, 0, 0, 16, 16, 8);  // Wall
            case WEST  -> box(8, 0, 0, 16, 16, 16); // Wall
            case EAST  -> box(0, 0, 0, 8, 16, 16);  // Wall
        };
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
        return true;
    }

	
    @Override
    public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return 0;
    }
}