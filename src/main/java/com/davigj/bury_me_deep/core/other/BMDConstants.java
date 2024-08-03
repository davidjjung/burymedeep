package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import com.ninni.spawn.registry.SpawnBlocks;

import java.util.HashMap;
import java.util.Map;

public class BMDConstants {
    public static final Map<Block, Block> CURIO_MAP = new HashMap<>();
    public static final Block antMound;

    public static void curioMap() {
        CURIO_MAP.put(Blocks.SAND, BMDBlocks.CURIOUS_SAND.get());
        CURIO_MAP.put(Blocks.GRAVEL, BMDBlocks.CURIOUS_GRAVEL.get());
        if (ModList.get().isLoaded("spawn")) {
            CURIO_MAP.put(Blocks.COARSE_DIRT, BMDBlocks.CURIOUS_COARSE_DIRT.get());
        }
    }

    static {
        antMound = ModList.get().isLoaded("spawn") ? SpawnBlocks.ANT_MOUND.get() : Blocks.COARSE_DIRT;
    }
}
