package net.teninsomniak.moretools.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.Random;
//temporarily unused, bcs i suck at it :P
//intended for distilled chorus
public class TeleportStatusEffect extends StatusEffect {
    public TeleportStatusEffect() {
        super(StatusEffectCategory.NEUTRAL, 0xC800FF);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 20 == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (!entity.getWorld().isClient()); {
            teleportPlayerRandomly(entity, entity.getWorld(), amplifier);
        }
    }
    public void teleportPlayerRandomly(LivingEntity entity, World world, int amplifier) {
        Random random = new Random();
        double teleportRadius = 8.0 + amplifier * 2;

        for (int i = 0; i < 16; i++) {
            double offsetX = (random.nextDouble() - 0.5) * teleportRadius;
            double offsetY = (random.nextInt(8) - 4);
            double offsetZ = (random.nextDouble() - 0.5) * teleportRadius;

            BlockPos targetPos = new BlockPos(entity.getX() + offsetX, entity.getY() + offsetY,entity.getZ() + offsetZ);

            if (isSafeTeleportLocation(world, targetPos)) {
                entity.teleport(targetPos.getX() + 0.5, targetPos.getY(), targetPos.getZ() + 0.5);
                spawnTeleportParticles(world, entity.getPos());
                world.playSound(null, entity.getBlockPos(), SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, entity.getSoundCategory(), 1.0F, 1.0F);
                break;
            }
        }
    }
    private boolean isSafeTeleportLocation(World world, BlockPos pos) {
        BlockPos belowPos = pos.down();
        return !world.getBlockState(belowPos).isAir() && !world.getBlockState(pos).isFullCube(world, pos)
                && !world.getBlockState(pos.up()).isFullCube(world, pos.up());
    }

    private void spawnTeleportParticles(World world, Vec3d position) {
        for (int i = 0; i < 32; i++) {
            double offsetX = (world.random.nextDouble() - 0.5) * 2.0;
            double offsetY = world.random.nextDouble() * 2.0;
            double offsetZ = (world.random.nextDouble() - 0.5) * 2.0;
            world.addParticle(ParticleTypes.PORTAL, position.x + offsetX, position.y + offsetY, position.z + offsetZ, 0, 0, 0);
        }
    }
}
