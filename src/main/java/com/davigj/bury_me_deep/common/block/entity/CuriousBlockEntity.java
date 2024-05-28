package com.davigj.bury_me_deep.common.block.entity;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.core.registry.BMDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class CuriousBlockEntity extends BlockEntity {
    public static int lifetime;
    public int MAX_LIFETIME = 50;
    public ItemStack cargo = ItemStack.EMPTY;

    public CuriousBlockEntity(BlockPos pos, BlockState state) {
        super(BMDBlockEntityTypes.CURIOUS_BLOCK.get(), pos, state);
        lifetime = MAX_LIFETIME;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CuriousBlockEntity entity) {
        if (!level.isClientSide && state.getBlock() instanceof CuriousBlock curious) {
            if (lifetime <= 0) {
                if (entity.cargo.isEmpty()) {
                    Block sad = curious.getSad();
                    level.setBlock(pos, sad.defaultBlockState(), 3);
                } else {
                    Block sus = curious.getSus();
                    BlockState converted = sus.defaultBlockState();
                    level.setBlock(pos, converted, 3);
                    BlockEntity blockEntity = level.getBlockEntity(pos);
                    if (blockEntity instanceof BrushableBlockEntity brushable) {
                        brushable.item = entity.cargo;
                    }
                    return;
                }
            }

            List<ItemEntity> itemList = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos).inflate(0.1));
            if (!itemList.isEmpty()) {
                if (entity.cargo.isEmpty() && level.getRandom().nextBoolean()) {
                    for (ItemEntity candidate : itemList) {
                        entity.setCargo(candidate.getItem());
                        BlockParticleOption crumbs = new BlockParticleOption(ParticleTypes.BLOCK, state);
                        ((ServerLevel)level).sendParticles(crumbs.setPos(pos), candidate.getX(), candidate.getY(),
                                candidate.getZ(), 9, 0, 0 + 0.05D, 0, 0.15D);
                        candidate.remove(Entity.RemovalReason.DISCARDED);
                        return;
                    }
                } else {
                    for (ItemEntity candidate : itemList) {
                        ItemStack stack = candidate.getItem();
                        if (entity.cargo.is(stack.getItem())) {
                            int maxAdd = entity.cargo.getMaxStackSize() - entity.cargo.getCount();
                            if (maxAdd > 0) {
                                int toAdd = Math.min(stack.getCount(), maxAdd);
                                entity.cargo.grow(toAdd);
                                stack.shrink(toAdd);
                                if (stack.isEmpty()) {
                                    candidate.remove(Entity.RemovalReason.DISCARDED);
                                }
                                break;
                            }
                        }
                    }
                }
            }
            lifetime--;
        }
    }

    private void setCargo(ItemStack stack) {
        this.cargo = stack.copy();
    }
}
