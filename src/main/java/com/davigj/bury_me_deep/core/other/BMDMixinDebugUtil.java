package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

import static com.davigj.bury_me_deep.core.other.BMDConstants.CURIO_MAP;

public class BMDMixinDebugUtil {
    public static void onUseTick(Level level, int remainingUseTicks, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        if (CURIO_MAP.containsKey(block) && remainingUseTicks < 180) {
            level.setBlock(pos, CURIO_MAP.get(block).defaultBlockState(), 3);
        } else if (level.getBlockEntity(pos) instanceof CuriousBlockEntity curious) {
            CuriousBlockEntity.lifetime = curious.MAX_LIFETIME;
        }
    }
}
