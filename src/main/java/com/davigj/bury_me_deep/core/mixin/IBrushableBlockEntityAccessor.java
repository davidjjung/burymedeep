package com.davigj.bury_me_deep.core.mixin;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BrushableBlockEntity.class)
public interface IBrushableBlockEntityAccessor {
    @Accessor
    void setItem(ItemStack stack);
}
