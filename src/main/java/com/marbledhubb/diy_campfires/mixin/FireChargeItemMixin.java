package com.marbledhubb.diy_campfires.mixin;

import com.marbledhubb.diy_campfires.init.blocks.FirewoodBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FireChargeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FireChargeItem.class)
public class FireChargeItemMixin {
    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockState blockState = level.getBlockState(context.getClickedPos());
        if (blockState.getBlock() instanceof  FirewoodBlock && blockState.getValue(FirewoodBlock.AMOUNT) >= FirewoodBlock.MAX_LOGS) {
            if (context.getPlayer() == null || context.getPlayer().isCrouching()) return;

            if (level.isClientSide) {
                Component component = Component.translatable("block.diy_campfires.firewood.finishing_material_required");
                context.getPlayer().displayClientMessage(component, true);
            }

            cir.setReturnValue(InteractionResult.FAIL);
        }
    }
}