package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.ninni.species.registry.SpeciesBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.ModList;
import com.ninni.spawn.registry.SpawnBlocks;

import java.util.HashMap;
import java.util.Map;

public class BMDConstants {
    public static final Map<Block, Block> SAD_TO_CURIOUS_MAP = new HashMap<>();
    public static final Map<Block, Block> CURIOUS_TO_SUS_MAP = new HashMap<>();

    public static final Block antMound;
    public static final Block redSus;

    public static void stcMap() {
        SAD_TO_CURIOUS_MAP.put(Blocks.SAND, BMDBlocks.CURIOUS_SAND.get());
        SAD_TO_CURIOUS_MAP.put(Blocks.GRAVEL, BMDBlocks.CURIOUS_GRAVEL.get());
        if (ModList.get().isLoaded("spawn")) {
            SAD_TO_CURIOUS_MAP.put(Blocks.COARSE_DIRT, BMDBlocks.CURIOUS_COARSE_DIRT.get());
        }
        if (ModList.get().isLoaded("species")) {
            SAD_TO_CURIOUS_MAP.put(Blocks.RED_SAND, BMDBlocks.RED_CURIOUS_SAND.get());
        }
    }

    public static void ctsMap() {
        CURIOUS_TO_SUS_MAP.put(BMDBlocks.CURIOUS_SAND.get(), Blocks.SUSPICIOUS_SAND);
        CURIOUS_TO_SUS_MAP.put(BMDBlocks.CURIOUS_GRAVEL.get(), Blocks.SUSPICIOUS_GRAVEL);
        if (ModList.get().isLoaded("spawn")) {
            CURIOUS_TO_SUS_MAP.put(BMDBlocks.CURIOUS_COARSE_DIRT.get(), antMound);
        }
        if (ModList.get().isLoaded("species")) {
            CURIOUS_TO_SUS_MAP.put(BMDBlocks.RED_CURIOUS_SAND.get(), redSus);
        }
    }

    static {
        antMound = !ModList.get().isLoaded("spawn") ? Blocks.COARSE_DIRT : SpawnBlocks.ANT_MOUND.get();
        redSus = !ModList.get().isLoaded("species") ? Blocks.COARSE_DIRT : SpeciesBlocks.RED_SUSPICIOUS_SAND.get();
    }
}
