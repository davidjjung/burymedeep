package com.davigj.bury_me_deep.core.registry;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.davigj.bury_me_deep.core.other.BMDConstants;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import static net.minecraft.world.item.crafting.Ingredient.of;

@Mod.EventBusSubscriber(modid = BuryMeDeep.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMDBlocks {
    public static final BlockSubRegistryHelper HELPER = BuryMeDeep.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> CURIOUS_SAND = HELPER.createBlock("curious_sand", () -> new CuriousBlock(Block.Properties.copy(Blocks.SUSPICIOUS_SAND)));
    public static final RegistryObject<Block> CURIOUS_GRAVEL = HELPER.createBlock("curious_gravel", () -> new CuriousBlock(Block.Properties.copy(Blocks.SUSPICIOUS_GRAVEL)));
    public static final RegistryObject<Block> CURIOUS_COARSE_DIRT = HELPER.createBlock("curious_coarse_dirt", () -> new CuriousBlock(Block.Properties.copy(Blocks.COARSE_DIRT)));

}