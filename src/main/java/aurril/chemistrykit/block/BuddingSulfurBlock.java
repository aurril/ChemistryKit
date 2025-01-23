package aurril.chemistrykit.block;

import aurril.chemistrykit.registry.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingSulfurBlock extends SulfurBlock {
    public static final int GROW_CHANCE = 5;
    private static final Direction[] DIRECTIONS = Direction.values();

    public BuddingSulfurBlock(AbstractBlock.Settings settings) { super(settings); }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(GROW_CHANCE) == 0) {
            Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
            BlockPos blockPos = pos.offset(direction);
            BlockState blockState = world.getBlockState(blockPos);
            Block block = null;
            if (canGrowIn(blockState)) {
                block = ModBlocks.SMALL_SULFUR_BUD;
            } else if (blockState.isOf(ModBlocks.SMALL_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
                block = ModBlocks.MEDIUM_SULFUR_BUD;
            } else if (blockState.isOf(ModBlocks.MEDIUM_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
                block = ModBlocks.LARGE_SULFUR_BUD;
            } else if (blockState.isOf(ModBlocks.LARGE_SULFUR_BUD) && blockState.get(SulfurClusterBlock.FACING) == direction) {
                block = ModBlocks.SULFUR_CLUSTER;
            }

            if (block != null) {
                BlockState blockState2 = (BlockState)((BlockState)block.getDefaultState().with(SulfurClusterBlock.FACING, direction)).with(SulfurClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
                world.setBlockState(blockPos, blockState2);
            }

        }
    }

    public static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }
}
