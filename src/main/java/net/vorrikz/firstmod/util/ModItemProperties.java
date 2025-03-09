package net.vorrikz.firstmod.util;

import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.component.ModDataComponentTypes;
import net.vorrikz.firstmod.item.ModItems;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        chisel();
        vorrikBow();
    }

    private static void chisel() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f : 0f);
    }

    private static void vorrikBow() {
        bow(ModItems.VORRIK_BOW.get());
    }

    // Helper function for bows
    private static void bow(Item item) {
        ItemProperties.register(item, ResourceLocation.withDefaultNamespace("pull"), (p_340951_, p_340952_, p_340953_, p_340954_) -> {
            if (p_340953_ == null) {
                return 0.0F;
            } else {
                return p_340953_.getUseItem() != p_340951_ ? 0.0F : (float)(p_340951_.getUseDuration(p_340953_) - p_340953_.getUseItemRemainingTicks()) / 20.0F;
            }
        });
        ItemProperties.register(
                item,
                ResourceLocation.withDefaultNamespace("pulling"),
                (p_174630_, p_174631_, p_174632_, p_174633_) -> p_174632_ != null && p_174632_.isUsingItem() && p_174632_.getUseItem() == p_174630_ ? 1.0F : 0.0F
        );
    }
}