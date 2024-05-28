package com.davigj.bury_me_deep.core.mixin;

import com.davigj.bury_me_deep.core.other.BMDMixinDebugUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BrushItem.class)
public class BrushItemMixin {

    @Inject(method = "onUseTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/Level;getBlockEntity(" +
            "Lnet/minecraft/core/BlockPos;)Lnet/minecraft/world/level/block/entity/BlockEntity;"),
            locals = LocalCapture.CAPTURE_FAILHARD)
    private void smellsSuspicious(Level level, LivingEntity living, ItemStack stack, int remainingUseTicks, CallbackInfo ci,
                                  Player $$5, HitResult $$6, BlockHitResult $$8, int $$9, boolean $$10, BlockPos pos,
                                  BlockState state) {
        BMDMixinDebugUtil.onUseTick(level, remainingUseTicks, pos, state);
    }
}
