package com.marbledhubb.diy_campfires.mixin;

import com.marbledhubb.diy_campfires.init.block.FirewoodBlock;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.FlintAndSteelItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlintAndSteelItem.class)
public class FlintAndSteelItemMixin {
    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Level level = context.getLevel();
        BlockState blockState = level.getBlockState(context.getClickedPos());
        if (blockState.getBlock() instanceof FirewoodBlock && blockState.getValue(FirewoodBlock.AMOUNT) >= FirewoodBlock.MAX_LOGS) {
            if (context.getPlayer() == null || context.getPlayer().isCrouching()) return;

            if (level.isClientSide()) {
                Component component = Component.translatable("block.diy_campfires.firewood.finishing_material_required");
                context.getPlayer().sendOverlayMessage(component);
            }

            cir.setReturnValue(InteractionResult.FAIL);
        }
    }
}