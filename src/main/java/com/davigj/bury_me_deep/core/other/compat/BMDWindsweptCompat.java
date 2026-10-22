package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.rosemods.windswept.core.registry.WindsweptBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import static com.davigj.bury_me_deep.core.other.compat.BMDModConstants.WINDSWEPT;

public class BMDWindsweptCompat {
    public static final Block susSnow;

    public static void addTrios() {
        BMDConstants.addTrio(Blocks.SNOW_BLOCK, BMDBlocks.CURIOUS_SNOW.get(), susSnow);
    }

    static {
        susSnow = !WINDSWEPT ? Blocks.SNOW_BLOCK : WindsweptBlocks.SUSPICIOUS_SNOW.get();
    }
}
