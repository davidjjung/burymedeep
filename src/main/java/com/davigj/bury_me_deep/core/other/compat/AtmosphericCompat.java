package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.ATMOSPHERIC;

public class AtmosphericCompat {
    public static final Block aridSus;
    public static final Block redAridSus;
    public static final Block arid;
    public static final Block redArid;


    public static void addTrios() {
        BMDConstants.addTrio(arid, BMDBlocks.CURIOUS_ARID_SAND.get(), aridSus);
        BMDConstants.addTrio(redArid, BMDBlocks.RED_CURIOUS_ARID_SAND.get(), redAridSus);
    }

    static {
        aridSus = !ATMOSPHERIC ? Blocks.SAND : AtmosphericBlocks.SUSPICIOUS_ARID_SAND.get();
        redAridSus = !ATMOSPHERIC ? Blocks.RED_SAND : AtmosphericBlocks.SUSPICIOUS_RED_ARID_SAND.get();
        arid = !ATMOSPHERIC ? Blocks.SAND : AtmosphericBlocks.ARID_SAND.get();
        redArid = !ATMOSPHERIC ? Blocks.RED_SAND : AtmosphericBlocks.RED_ARID_SAND.get();
    }
}
