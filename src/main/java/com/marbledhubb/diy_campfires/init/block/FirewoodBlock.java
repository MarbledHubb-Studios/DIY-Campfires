package com.marbledhubb.diy_campfires.init.block;

import com.marbledhubb.diy_campfires.init.ModBlockStateProperties;
import com.marbledhubb.diy_campfires.init.ModTags;
import com.mojang.serialization.MapCodec;
import de.cech12.unlitcampfire.mixinaccess.ICampfireBlockMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FirewoodBlock extends HorizontalDirectionalBlock {
    public static final int MAX_LOGS = 4;
    public static final EnumProperty<@NotNull Direction> FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final IntegerProperty AMOUNT = ModBlockStateProperties.LOG_AMOUNT;

    private final Block campfireBlock;
    private final Block soulCampfireBlock;

    public FirewoodBlock(BlockBehaviour.Properties properties, Block campfireBlock, Block soulCampfireBlock) {
        super(properties);
        this.campfireBlock = campfireBlock;
        this.soulCampfireBlock = soulCampfireBlock;
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH).setValue(AMOUNT, 1));
    }

    @Override
    protected MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return null;
    }

    @Override
    public @NotNull VoxelShape getShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
        return Block.box(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull InteractionResult useItemOn(ItemStack stack, BlockState state, @NotNull Level level,
                                                @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand,
                                                @NotNull BlockHitResult hit) {

        int amount = state.getValue(AMOUNT);

        if (stack.getItem() == this.asItem()) {

            if (amount < MAX_LOGS) {
                level.setBlock(pos, state.setValue(AMOUNT, amount + 1), 4);
            } else {
                return InteractionResult.FAIL;
            }

            if (!player.isCreative()) {
                stack.shrink(1);
            }

            level.playSound(player, pos, getSoundType(state, level, pos, player).getPlaceSound(), SoundSource.BLOCKS, 1.0f, 1.0f);

            return InteractionResult.SUCCESS;
        }

        if (amount >= MAX_LOGS) {

            if (stack.is(ModTags.Items.CAMPFIRE_FINISHING_MATERIAL)) {
                makeCampfire(campfireBlock, pos, state, stack, player, level);
                return InteractionResult.SUCCESS;
            } else if (stack.is(ModTags.Items.SOUL_CAMPFIRE_FINISHING_MATERIAL)) {
                makeCampfire(soulCampfireBlock, pos, state, stack, player, level);
                return InteractionResult.SUCCESS;
            }

        }

        return InteractionResult.FAIL;
    }

    private void makeCampfire(Block campfireBlock, BlockPos pos, BlockState state, ItemStack stack, Player player, Level level) {
        BlockState campfireState = campfireBlock.defaultBlockState()
                .setValue(CampfireBlock.LIT, false)
                .setValue(CampfireBlock.FACING, state.getValue(FACING).getOpposite());

        if (net.neoforged.fml.ModList.get().isLoaded("unlitcampfire"))
            campfireState = campfireState
                    .setValue(ICampfireBlockMixin.INFINITE, false)
                    .setValue(ICampfireBlockMixin.RUNS_OUT, false);

        level.setBlock(pos, campfireState, 4);
        if (!player.isCreative()) {
            stack.shrink(1);
        }
        level.playSound(player, pos, SoundEvents.SAND_PLACE, SoundSource.BLOCKS, 1.0f, 1.0f);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, AMOUNT);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level level, BlockPos pos, Player player, ItemStack toolStack, boolean willHarvest, FluidState fluid) {

        if (!level.isClientSide()) {
            int amount = state.getValue(AMOUNT);

            if (amount > 1) {
                level.setBlock(pos, state.setValue(AMOUNT, amount - 1), 3);

                if (!player.isCreative())
                    popResource(level, pos, new ItemStack(this));

                level.levelEvent(player, 2001, pos, Block.getId(state));

                return false;
            }
        }

        if (!player.isCreative())
            popResource(level, pos, new ItemStack(this));
        return super.onDestroyedByPlayer(state, level, pos, player, toolStack, willHarvest, fluid);
    }

    @Override
    public @NotNull BlockState rotate(@NotNull BlockState state, @NotNull LevelAccessor level, @NotNull BlockPos pos, @NotNull Rotation direction) {
        return super.rotate(state, level, pos, direction);
    }

    @Override
    public int getFlammability(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }

    @Override
    public boolean isFlammable(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return true;
    }

    @Override
    public int getFireSpreadSpeed(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull Direction direction) {
        return 5;
    }
}