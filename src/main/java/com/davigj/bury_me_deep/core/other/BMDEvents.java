package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.davigj.bury_me_deep.core.mixin.IBrushItemInvoker;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BrushItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;

@EventBusSubscriber(modid = BuryMeDeep.MOD_ID)
public class BMDEvents {
    @SubscribeEvent
    public static void createCuriousBlock(LivingEntityUseItemEvent.Tick event) {
        if (event.getItem().getItem() instanceof BrushItem brush &&
                event.getEntity() instanceof Player player) {
            HitResult result = ((IBrushItemInvoker)brush).callCalculateHitResult(player);
            if (result instanceof BlockHitResult bhr && result.getType() == HitResult.Type.BLOCK) {
                boolean $$10 = event.getDuration() % 25 == 5;
                if ($$10) {
                    Level level = player.level();
                    BlockPos $$11 = bhr.getBlockPos();
                    BlockState $$12 = level.getBlockState($$11);
                    if (!level.isClientSide) {
                        BMDUseTickEventUtil.onUseTick(level, brush.getUseDuration(event.getItem(), player) - event.getDuration(),
                                $$11, $$12);
                    }
                }
            }
        }
    }
}