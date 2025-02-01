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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = BuryMeDeep.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMDBlocks {
    public static final BlockSubRegistryHelper HELPER = BuryMeDeep.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> CURIOUS_SAND = HELPER.createBlock("curious_sand", () -> new CuriousBlock(Block.Properties.copy(Blocks.SUSPICIOUS_SAND)));
    public static final RegistryObject<Block> CURIOUS_GRAVEL = HELPER.createBlock("curious_gravel", () -> new CuriousBlock(Block.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)));
    public static final RegistryObject<Block> CURIOUS_COARSE_DIRT = HELPER.createBlock("curious_coarse_dirt", () -> new CuriousBlock(Block.Properties.copy(Blocks.COARSE_DIRT)));
    public static final RegistryObject<Block> RED_CURIOUS_SAND = HELPER.createBlock("red_curious_sand", () -> new CuriousBlock(Block.Properties.copy(Blocks.RED_SAND)));
    public static final RegistryObject<Block> CURIOUS_SOUL_SAND = HELPER.createBlock("curious_soul_sand", () -> new CuriousBlock(Block.Properties.copy(Blocks.SOUL_SAND)));
    public static final RegistryObject<Block> CURIOUS_ARID_SAND = HELPER.createBlock("curious_arid_sand", () -> new CuriousBlock(Block.Properties.copy(Blocks.SUSPICIOUS_SAND)));
    public static final RegistryObject<Block> RED_CURIOUS_ARID_SAND = HELPER.createBlock("red_curious_arid_sand", () -> new CuriousBlock(Block.Properties.of()
            .mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.SNARE).strength(0.25F).sound(SoundType.SUSPICIOUS_SAND).pushReaction(PushReaction.DESTROY)));

}