package com.davigj.bury_me_deep.core.registry;

import com.davigj.bury_me_deep.common.block.entity.CuriousBlockEntity;
import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.teamabnormals.blueprint.core.util.registry.BlockEntitySubRegistryHelper;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.Set;
import java.util.function.Supplier;

public class BMDBlockEntityTypes {
    public static final BlockEntitySubRegistryHelper BLOCK_ENTITIES = BuryMeDeep.REGISTRY_HELPER.getBlockEntitySubHelper();

    public static final Supplier<BlockEntityType<CuriousBlockEntity>> CURIOUS_BLOCK =
            BLOCK_ENTITIES.createBlockEntity("curious_block", CuriousBlockEntity::new, () -> Set.of(
                    BMDBlocks.CURIOUS_SAND.get(),
                    BMDBlocks.CURIOUS_GRAVEL.get(),
                    BMDBlocks.CURIOUS_COARSE_DIRT.get(),
                    BMDBlocks.RED_CURIOUS_SAND.get(),
                    BMDBlocks.CURIOUS_SOUL_SAND.get(),
                    BMDBlocks.CURIOUS_ARID_SAND.get(),
                    BMDBlocks.RED_CURIOUS_ARID_SAND.get()
            ));
}
