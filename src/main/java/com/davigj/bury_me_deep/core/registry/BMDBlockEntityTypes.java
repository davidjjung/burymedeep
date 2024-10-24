package com.davigj.bury_me_deep.core.registry;

import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

@Mod.EventBusSubscriber(modid = BuryMeDeep.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BMDBlockEntityTypes {
    public static final BlockEntitySubRegistryHelper HELPER = BuryMeDeep.REGISTRY_HELPER.getBlockEntitySubHelper();

    public static final RegistryObject<BlockEntityType<CuriousBlockEntity>> CURIOUS_BLOCK =
            HELPER.createBlockEntity("curious_block", CuriousBlockEntity::new, () -> Set.of(
                    BMDBlocks.CURIOUS_SAND.get(),
                    BMDBlocks.CURIOUS_GRAVEL.get(),
                    BMDBlocks.CURIOUS_COARSE_DIRT.get(),
                    BMDBlocks.RED_CURIOUS_SAND.get(),
                    BMDBlocks.CURIOUS_SOUL_SAND.get()
            ));
}
