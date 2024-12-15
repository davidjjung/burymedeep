package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import com.davigj.bury_me_deep.core.BMDConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;

import static com.davigj.bury_me_deep.core.other.BMDConstants.SAD_TO_CURIOUS_MAP;

public class BMDUseTickEventUtil {
    public static void onUseTick(Level level, int remainingUseTicks, BlockPos pos, BlockState state) {
        Block block = state.getBlock();
        if (SAD_TO_CURIOUS_MAP.containsKey(block) && remainingUseTicks < 200 - 18) {
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
            BlockState turnsInto = SAD_TO_CURIOUS_MAP.get(block).defaultBlockState();
            level.setBlock(pos, turnsInto, 3);
            if (turnsInto.getBlock() instanceof CuriousBlock curio) {
                level.playSound(null, pos, ((BrushableBlock)curio.getSus()).getBrushSound(), SoundSource.BLOCKS, 1.2F, 2.0F);
            }
        } else if (level.getBlockEntity(pos) instanceof CuriousBlockEntity curious) {
            curious.lifetime = CuriousBlockEntity.MAX_LIFETIME;
        }
    }
}
