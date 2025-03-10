package net.vorrikz.firstmod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class BismuthLampBlock extends Block {
    public static final BooleanProperty CLICKED = BooleanProperty.create("clicked");

    public BismuthLampBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(CLICKED, false));
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, BlockHitResult pHitResult) {
        if(!pLevel.isClientSide) {
            boolean currentState = pState.getValue(CLICKED);
            pLevel.setBlockAndUpdate(pPos, pState.setValue(CLICKED, !currentState));
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(CLICKED);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, fromPos, isMoving);

        // Check if this block is providing a redstone signal
        int power = level.getSignal(fromPos, Direction.UP); // Get signal power from target block

        if (power > 0 && !state.getValue(CLICKED)) {
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, true)); // Turn on the lamp
        } else if (power == 0 && state.getValue(CLICKED)) {
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, false)); // Turn off the lamp
        }

        // Check for redstone power from other blocks (redstone wire, torch, etc.)
        power = level.getSignal(pos, Direction.UP); // Get the redstone signal at the position of this block
        if (power > 0 && !state.getValue(CLICKED)) {
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, true)); // Turn on the lamp
        } else if (power == 0 && state.getValue(CLICKED)) {
            level.setBlockAndUpdate(pos, state.setValue(CLICKED, false)); // Turn off the lamp
        }
    }


    @Override
    protected boolean hasAnalogOutputSignal(BlockState pState) {
        return pState.getValue(CLICKED);
    }

    @Override
    protected int getAnalogOutputSignal(BlockState pState, Level pLevel, BlockPos pPos) {
        return pState.getValue(CLICKED) ? 15: 0;
    }
}
