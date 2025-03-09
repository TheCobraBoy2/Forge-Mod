package net.vorrikz.firstmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

public class SlimeyEffect extends MobEffect {
    public SlimeyEffect(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    @Override
    public boolean applyEffectTick(LivingEntity pEntity, int pAmplifier) {
        if (pEntity.horizontalCollision) {
            Vec3 initialVector = pEntity.getDeltaMovement();
            Vec3 climbVec = new Vec3(initialVector.x, 0.2D, initialVector.z);
            pEntity.setDeltaMovement(climbVec.scale(0.97D));
            return true;
        }

        return super.applyEffectTick(pEntity, pAmplifier);
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int pDuration, int pAmplifier) {
        return true;
    }
}
