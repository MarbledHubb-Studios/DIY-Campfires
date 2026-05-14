package com.marbledhubb.diy_campfires.init.block;

import com.marbledhubb.diy_campfires.init.ModBlockStateProperties;
import com.marbledhubb.diy_campfires.init.ModTags;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class FirewoodBlock extends HorizontalDirectionalBlock {
    public static final int MIN_LOGS = 1;
    public static final int MAX_LOGS = 4;
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = ModBlockStateProperties.LOG_AMOUNT;

    public FirewoodBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AMOUNT, 1));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    private static final VoxelShape DEFAULT = Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);

    @Override
    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return switch (pState.getValue(FACING)) {
            default -> DEFAULT;
        };
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level,
                                           BlockPos pos, Player player, InteractionHand hand,
                                           BlockHitResult hit) {

        int amount = state.getValue(AMOUNT);

        if (stack.getItem() == this.asItem()) {

            if (amount < MAX_LOGS) {
                level.setBlock(pos, state.setValue(AMOUNT, amount + 1), 4);
            } else {
                return ItemInteractionResult.FAIL;
            }

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.playSound(player, pos, SoundEvents.WOOD_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);

            return ItemInteractionResult.SUCCESS;
        }

        if (amount >= MAX_LOGS) {

            if (stack.is(ModTags.Items.CAMPFIRE_FINISHING_MATERIAL)) {
                level.setBlock(pos,
                        Blocks.CAMPFIRE.defaultBlockState()
                                .setValue(CampfireBlock.LIT, false)
                                .setValue(CampfireBlock.FACING, state.getValue(FACING).getOpposite()),
                        4);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                return ItemInteractionResult.SUCCESS;
            } else if (stack.is(ModTags.Items.SOUL_CAMPFIRE_FINISHING_MATERIAL)) {
                level.setBlock(pos,
                        Blocks.SOUL_CAMPFIRE.defaultBlockState()
                                .setValue(CampfireBlock.LIT, false)
                                .setValue(CampfireBlock.FACING, state.getValue(FACING).getOpposite()),
                        4);
                if (!player.isCreative()) {
                    stack.shrink(1);
                }
                level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
                return ItemInteractionResult.SUCCESS;
            }

        }

        return ItemInteractionResult.FAIL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AMOUNT);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos,
                                       Player player, boolean willHarvest, FluidState fluid) {

        if (!level.isClientSide) {
            int amount = state.getValue(AMOUNT);

            if (amount > 1) {
                level.setBlock(pos, state.setValue(AMOUNT, amount - 1), 3);

                if (!player.isCreative())
                    popResource(level, pos, new ItemStack(this));

                level.playSound(null, pos, SoundEvents.WOOD_BREAK, SoundSource.BLOCKS,
                        1.0f, 1.0f);

                level.levelEvent(player, 2001, pos, Block.getId(state));

                return false;
            }
        }

        if (!player.isCreative())
            popResource(level, pos, new ItemStack(this));
        return super.onDestroyedByPlayer(state, level, pos, player, willHarvest, fluid);
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        return super.rotate(state, level, pos, direction);
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }
}