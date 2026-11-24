package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.ninni.species.registry.SpeciesBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.SPECIES;

public class SpeciesCompat {
    public static final Block susRed;

    public static void addTrios() {
        BMDConstants.addTrio(Blocks.RED_SAND, BMDBlocks.RED_CURIOUS_SAND_SPECIES.get(), susRed);
    }

    static {
        susRed = !SPECIES ? Blocks.RED_SAND : SpeciesBlocks.RED_SUSPICIOUS_SAND.get();
    }
}
