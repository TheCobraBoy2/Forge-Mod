package net.vorrikz.firstmod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    // The m_38762 is effect my parchment version seems to not include this.
    public static final FoodProperties KOHLRABI =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.25f)
                    .m_38762_(new MobEffectInstance(MobEffects.INVISIBILITY, 400), 0.10f).build();

    public static final FoodProperties RADISH =
            new FoodProperties.Builder()
                    .nutrition(4)
                    .saturationModifier(0.25f).build();

    // I think the .m_38766_ is .fast not certain though
    public static final FoodProperties HONEY_BERRY =
            new FoodProperties.Builder()
                    .nutrition(2)
                    .saturationModifier(0.15f).m_38766_().build();

    public static final FoodProperties GOJI_BERRY =
            new FoodProperties.Builder()
                    .nutrition(3)
                    .saturationModifier(0.3f).m_38766_().build();
}
