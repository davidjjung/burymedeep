package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.other.compat.*;
import com.davigj.bury_me_deep.core.registry.BMDBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.ArrayList;
import java.util.List;

import static com.davigj.bury_me_deep.core.other.compat.ModConstants.*;

public class BMDConstants {
    public static final List<BrushableTrio> TRIOS = new ArrayList<>();

    static {
        addTrio(Blocks.SAND, BMDBlocks.CURIOUS_SAND.get(), Blocks.SUSPICIOUS_SAND);
        addTrio(Blocks.GRAVEL, BMDBlocks.CURIOUS_GRAVEL.get(), Blocks.SUSPICIOUS_GRAVEL);
        if (ATMOSPHERIC) AtmosphericCompat.addTrios();
        if (SPAWN) SpawnCompat.addTrios();
        if (WINDSWEPT) WindsweptCompat.addTrios();
        if (AA) AACompat.addTrios();
        if (JNE) JNECompat.addTrios();
        if (BLASTED_BARRENS) BBCompat.addTrios();
        if (SPECIES) SpeciesCompat.addTrios();
    }

    public static void addTrio(Block boring, Block curious, Block sus) {
        TRIOS.add(new BrushableTrio(boring, curious, sus));
    }

    public static BrushableTrio getTrio(Block curious) {
        return TRIOS.stream().filter(trio -> trio.curious() == curious).findFirst().orElse(null);
    }

    public static BrushableTrio getTrioFromBoring(Block boring) {
        return TRIOS.stream().filter(trio -> trio.boring() == boring).findFirst().orElse(null);
    }

    public record BrushableTrio(Block boring, Block curious, Block sus) {}
}
