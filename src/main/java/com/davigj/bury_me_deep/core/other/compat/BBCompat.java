package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.blasted_barrens.core.registry.BBBlocks;
import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.jadenxgamer.netherexp.registry.JNEBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.BLASTED_BARRENS;
import static com.davigj.bury_me_deep.core.other.compat.ModConstants.JNE;

public class BBCompat {
    public static final Block ashen;

    public static void addTrios() {
        BMDConstants.addTrio(BBBlocks.ASHEN_SAND.get(), BMDBlocks.CURIOUS_ASHEN_SAND.get(), ashen);
    }

    static {
        ashen = !BLASTED_BARRENS ? BBBlocks.ASHEN_SAND.get() : BBBlocks.SUSPICIOUS_ASHEN_SAND.get();
    }
}
