package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.HashMap;
import java.util.Map;

public class BMDConstants {
    public static final Map<Block, Block> CURIO_MAP = new HashMap<>();

    public static void curioMap() {
        CURIO_MAP.put(Blocks.SAND, BMDBlocks.CURIOUS_SAND.get());
        CURIO_MAP.put(Blocks.GRAVEL, BMDBlocks.CURIOUS_GRAVEL.get());
    }

}
