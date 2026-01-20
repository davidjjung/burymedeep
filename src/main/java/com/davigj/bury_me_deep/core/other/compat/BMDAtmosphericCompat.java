package com.davigj.bury_me_deep.core.other.compat;

import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import com.teamabnormals.atmospheric.core.registry.AtmosphericBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.fml.ModList;

import java.util.Map;

public class BMDAtmosphericCompat {
    public static final Block aridSus;
    public static final Block redAridSus;

    public static void addBlocks(Map<Block, Block> map){
        map.put(BMDBlocks.CURIOUS_ARID_SAND.get(), aridSus);
        map.put(BMDBlocks.RED_CURIOUS_ARID_SAND.get(), redAridSus);
    }

    static {
        aridSus = !ModList.get().isLoaded("atmospheric") ? Blocks.SAND : AtmosphericBlocks.SUSPICIOUS_ARID_SAND.get();
        redAridSus = !ModList.get().isLoaded("atmospheric") ? Blocks.RED_SAND : AtmosphericBlocks.SUSPICIOUS_RED_ARID_SAND.get();
    }
}
