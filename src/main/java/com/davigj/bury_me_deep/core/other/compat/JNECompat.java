package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.jadenxgamer.netherexp.registry.JNEBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.JNE;

public class JNECompat {
    public static final Block soulSus;

    public static void addTrios() {
        BMDConstants.addTrio(Blocks.SOUL_SAND, BMDBlocks.CURIOUS_SOUL_SAND.get(), soulSus);
    }

    static {
        soulSus = !JNE ? Blocks.SOUL_SAND : JNEBlocks.SUSPICIOUS_SOUL_SAND.get();
    }
}
