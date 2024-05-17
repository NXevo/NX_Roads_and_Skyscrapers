
package net.mcreator.nxroads.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SingleMiddleLineSlopeRoadX1Block extends Block implements SimpleWaterloggedBlock {
	public static final DirectionProperty FACING = HorizontalDirectionalBlock.FACING;
	public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

	public SingleMiddleLineSlopeRoadX1Block() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.DEEPSLATE_BRICKS).strength(1f, 10f).noOcclusion().isRedstoneConductor((bs, br, bp) -> false));
		this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(WATERLOGGED, false));
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state, BlockGetter reader, BlockPos pos) {
		return state.getFluidState().isEmpty();
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 0;
	}

	@Override
	public VoxelShape getVisualShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return Shapes.empty();
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		return switch (state.getValue(FACING)) {
			default -> Shapes.or(box(0, 0, 0, 16, 16, 1), box(0, 0, 1, 16, 15, 2), box(0, 0, 2, 16, 14, 3), box(0, 0, 3, 16, 13, 4), box(0, 0, 4, 16, 12, 5), box(0, 0, 5, 16, 11, 6), box(0, 0, 6, 16, 10, 7), box(0, 0, 7, 16, 9, 8),
					box(0, 0, 8, 16, 8, 9), box(0, 0, 9, 16, 7, 10), box(0, 0, 10, 16, 6, 11), box(0, 0, 11, 16, 5, 12), box(0, 0, 12, 16, 4, 13), box(0, 0, 13, 16, 3, 14), box(0, 0, 14, 16, 2, 15), box(0, 0, 15, 16, 1, 16));
			case NORTH -> Shapes.or(box(0, 0, 15, 16, 16, 16), box(0, 0, 14, 16, 15, 15), box(0, 0, 13, 16, 14, 14), box(0, 0, 12, 16, 13, 13), box(0, 0, 11, 16, 12, 12), box(0, 0, 10, 16, 11, 11), box(0, 0, 9, 16, 10, 10), box(0, 0, 8, 16, 9, 9),
					box(0, 0, 7, 16, 8, 8), box(0, 0, 6, 16, 7, 7), box(0, 0, 5, 16, 6, 6), box(0, 0, 4, 16, 5, 5), box(0, 0, 3, 16, 4, 4), box(0, 0, 2, 16, 3, 3), box(0, 0, 1, 16, 2, 2), box(0, 0, 0, 16, 1, 1));
			case EAST -> Shapes.or(box(0, 0, 0, 1, 16, 16), box(1, 0, 0, 2, 15, 16), box(2, 0, 0, 3, 14, 16), box(3, 0, 0, 4, 13, 16), box(4, 0, 0, 5, 12, 16), box(5, 0, 0, 6, 11, 16), box(6, 0, 0, 7, 10, 16), box(7, 0, 0, 8, 9, 16),
					box(8, 0, 0, 9, 8, 16), box(9, 0, 0, 10, 7, 16), box(10, 0, 0, 11, 6, 16), box(11, 0, 0, 12, 5, 16), box(12, 0, 0, 13, 4, 16), box(13, 0, 0, 14, 3, 16), box(14, 0, 0, 15, 2, 16), box(15, 0, 0, 16, 1, 16));
			case WEST -> Shapes.or(box(15, 0, 0, 16, 16, 16), box(14, 0, 0, 15, 15, 16), box(13, 0, 0, 14, 14, 16), box(12, 0, 0, 13, 13, 16), box(11, 0, 0, 12, 12, 16), box(10, 0, 0, 11, 11, 16), box(9, 0, 0, 10, 10, 16), box(8, 0, 0, 9, 9, 16),
					box(7, 0, 0, 8, 8, 16), box(6, 0, 0, 7, 7, 16), box(5, 0, 0, 6, 6, 16), box(4, 0, 0, 5, 5, 16), box(3, 0, 0, 4, 4, 16), box(2, 0, 0, 3, 3, 16), box(1, 0, 0, 2, 2, 16), box(0, 0, 0, 1, 1, 16));
		};
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		builder.add(FACING, WATERLOGGED);
	}

	@Override
	public BlockState getStateForPlacement(BlockPlaceContext context) {
		boolean flag = context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER;
		return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, flag);
	}

	public BlockState rotate(BlockState state, Rotation rot) {
		return state.setValue(FACING, rot.rotate(state.getValue(FACING)));
	}

	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		return state.rotate(mirrorIn.getRotation(state.getValue(FACING)));
	}

	@Override
	public FluidState getFluidState(BlockState state) {
		return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
	}

	@Override
	public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor world, BlockPos currentPos, BlockPos facingPos) {
		if (state.getValue(WATERLOGGED)) {
			world.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
		}
		return super.updateShape(state, facing, facingState, world, currentPos, facingPos);
	}
}
