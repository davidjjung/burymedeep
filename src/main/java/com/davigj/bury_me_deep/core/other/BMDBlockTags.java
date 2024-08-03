package com.davigj.bury_me_deep.core.other;

import com.davigj.bury_me_deep.core.BuryMeDeep;
import com.teamabnormals.blueprint.core.util.TagUtil;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class BMDBlockTags {
    public static final TagKey<Block> ANT_MOUND_ADJACENTS = blockTag("ant_mounds");

    private static TagKey<Block> blockTag(String name) {
        return TagUtil.blockTag(BuryMeDeep.MOD_ID, name);
    }
}
