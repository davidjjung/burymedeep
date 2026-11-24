package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.ninni.spawn.registry.SpawnBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.SPAWN;

public class SpawnCompat {
    public static final Block antMound;

    public static void addTrios() {
        BMDConstants.addTrio(Blocks.COARSE_DIRT, BMDBlocks.CURIOUS_COARSE_DIRT.get(), antMound);
    }

    static {
        antMound = !SPAWN ? Blocks.COARSE_DIRT : SpawnBlocks.ANT_MOUND.get();
    }
}
