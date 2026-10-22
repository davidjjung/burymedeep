package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.sheddmer.abundant_atmosphere.common.init.AABlocks;

import static com.davigj.bury_me_deep.core.other.compat.BMDModConstants.AA;

public class BMDAACompat {
    public static final Block redSus;

    public static void addTrios() {
        BMDConstants.addTrio(Blocks.RED_SAND, BMDBlocks.RED_CURIOUS_SAND.get(), redSus);
    }

    static {
        redSus = !AA ? Blocks.RED_SAND : AABlocks.SUSPICIOUS_RED_SAND.get();
    }
}
