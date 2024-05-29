package com.davigj.bury_me_deep.common.block.entity;

import com.davigj.bury_me_deep.common.block.CuriousBlock;
import com.davigj.bury_me_deep.core.registry.BMDBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

import static com.davigj.bury_me_deep.common.block.CuriousBlock.DUSTED;

public class CuriousBlockEntity extends BlockEntity {
    public static int MAX_LIFETIME = 45;
    public static int HALF_LIFE = 30;
    public static int LAST_LIFE = 12;

    public int lifetime;
    public ItemStack cargo = ItemStack.EMPTY;

    public CuriousBlockEntity(BlockPos pos, BlockState state) {
        super(BMDBlockEntityTypes.CURIOUS_BLOCK.get(), pos, state);
        lifetime = MAX_LIFETIME;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, CuriousBlockEntity entity) {
        if (!level.isClientSide && state.getBlock() instanceof CuriousBlock curious) {
            // Set the block if its life is over
            if (entity.lifetime <= 0) {
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
                        level.playSound(null, pos, ((BrushableBlock)sus).getBrushCompletedSound(), SoundSource.BLOCKS, 0.8F, 1.0F);
                    }
                    return;
                }
            }
            int dustiness = state.getValue(DUSTED);
            // Otherwise, determine block cargo
            List<ItemEntity> itemList = level.getEntitiesOfClass(ItemEntity.class, new AABB(pos).inflate(0.1));
            if (!itemList.isEmpty()) {
                if (entity.cargo.isEmpty() && level.getRandom().nextBoolean()) {
                    for (ItemEntity candidate : itemList) {
                        entity.setCargo(candidate.getItem());
                        if (dustiness <= 2) {
                            entity.lifetime = HALF_LIFE - 1;
                        }
                        candidateRemoval(level, candidate, pos, state, 8, (BrushableBlock) curious.getSus());
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
                                    if (dustiness <= 2) {
                                        entity.lifetime = HALF_LIFE - 1;
                                    }
                                    candidateRemoval(level, candidate, pos, state, 4, (BrushableBlock) curious.getSus());
                                }
                                break;
                            }
                        }
                    }
                }
            }
            // Set the visual state of the block
            int newDustiness;

            if (entity.lifetime <= MAX_LIFETIME && entity.lifetime >= HALF_LIFE) {
                newDustiness = 3;
            } else if (entity.lifetime < HALF_LIFE && entity.lifetime > LAST_LIFE) {
                newDustiness = 2;
            } else {
                newDustiness = 1;
            }

            if (dustiness != newDustiness) {
                level.setBlock(pos, state.setValue(DUSTED, newDustiness), 3);
            }
            entity.lifetime--;
        }
    }

    private void setCargo(ItemStack stack) {
        this.cargo = stack.copy();
    }

    private static void candidateRemoval(Level level, ItemEntity candidate, BlockPos pos, BlockState state, int numParticles, BrushableBlock soundBlock) {
        level.playSound(null, pos, soundBlock.getBrushSound(), SoundSource.BLOCKS, 1.2F, 1.6F);
        BlockParticleOption crumbs = new BlockParticleOption(ParticleTypes.BLOCK, state);
        ((ServerLevel)level).sendParticles(crumbs.setPos(pos), candidate.getX(), candidate.getY(),
                candidate.getZ(), numParticles, 0, 0 + 0.05D, 0, 0.15D);
        candidate.remove(Entity.RemovalReason.DISCARDED);
    }
}
