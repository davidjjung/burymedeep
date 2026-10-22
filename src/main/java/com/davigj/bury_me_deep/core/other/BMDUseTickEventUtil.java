package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.fml.ModList;

public class BMDUseTickEventUtil {
    public static void onUseTick(Level level, int remainingUseTicks, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        BMDConstants.BrushableTrio trio = BMDConstants.getTrioFromBoring(block);
        if (trio != null && remainingUseTicks < 200 - 18) {
            if (block == Blocks.COARSE_DIRT && ModList.get().isLoaded("spawn")) {
                int i = 0;
                for (Direction direction : Direction.values()) {
                    BlockPos blockpos = pos.relative(direction);
                    BlockState block2 = level.getBlockState(blockpos);
                    if (block2.is(BMDBlockTags.ANT_MOUND_ADJACENTS)) {
                        i++;
                    }
                }
                if (i == 0) return;
            }
            BlockState turnsInto = trio.curious().defaultBlockState();
            level.setBlock(pos, turnsInto, 3);
            if (turnsInto.getBlock() instanceof CuriousBlock curio) {
                level.playSound(null, pos, ((BrushableBlock)curio.getSus()).getBrushSound(), SoundSource.BLOCKS, 1.2F, 2.0F);
            }
        } else if (level.getBlockEntity(pos) instanceof CuriousBlockEntity curious) {
            curious.lifetime = CuriousBlockEntity.MAX_LIFETIME;
        }
    }
}
