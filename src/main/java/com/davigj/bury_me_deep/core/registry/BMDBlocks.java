package com.davigj.bury_me_deep.core.registry;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class BMDBlocks {
    public static final BlockSubRegistryHelper BLOCKS = BuryMeDeep.REGISTRY_HELPER.getBlockSubHelper();

    public static final Supplier<Block> CURIOUS_SAND = BLOCKS.createBlock("curious_sand", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.SUSPICIOUS_SAND)));
    public static final Supplier<Block> CURIOUS_GRAVEL = BLOCKS.createBlock("curious_gravel", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.SUSPICIOUS_GRAVEL)));
    public static final Supplier<Block> CURIOUS_COARSE_DIRT = BLOCKS.createBlock("curious_coarse_dirt", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.COARSE_DIRT)));
    public static final Supplier<Block> RED_CURIOUS_SAND = BLOCKS.createBlock("red_curious_sand", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.RED_SAND)));
    public static final Supplier<Block> CURIOUS_SOUL_SAND = BLOCKS.createBlock("curious_soul_sand", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.SOUL_SAND)));
    public static final Supplier<Block> CURIOUS_ARID_SAND = BLOCKS.createBlock("curious_arid_sand", () -> new CuriousBlock(Block.Properties.ofFullCopy(Blocks.SUSPICIOUS_SAND)));
    public static final Supplier<Block> RED_CURIOUS_ARID_SAND = BLOCKS.createBlock("red_curious_arid_sand", () -> new CuriousBlock(Block.Properties.of()
            .mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY)));

}