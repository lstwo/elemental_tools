package net.lstwo.elemental_tools.item.pickaxe;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class AirPickaxe extends PickaxeItem {
    public AirPickaxe(ToolMaterial material) {
        super(material, 10, -0.8F, new Settings().group(ItemGroup.TOOLS).maxCount(1).maxDamage(1280).
                rarity(Rarity.EPIC));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) miner;
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 120, 2));
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 240, 1));
        }
        ((ServerWorld) world).spawnParticles(ParticleTypes.POOF, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 10, 0.2, 0.2, 0.2, 0.1);
        ((ServerWorld) world).spawnParticles(ParticleTypes.CLOUD, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 30, 0.1, 0.1, 0.1, 0.1);
        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 10));
        return super.postHit(stack, target, attacker);
    }
}