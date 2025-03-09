package net.vorrikz.firstmod.potion;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.effect.ModEffects;

public class ModPotions {
    public static final DeferredRegister<Potion> POTIONS =
            DeferredRegister.create(ForgeRegistries.POTIONS, FirstMod.MOD_ID);

    public static final RegistryObject<Potion> SLIMEY_POTION = POTIONS.register("firstmod.slimey_potion",
        () -> new Potion(new MobEffectInstance(ModEffects.SLIMEY_EFFECT.getHolder().get(), 200, 0)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
