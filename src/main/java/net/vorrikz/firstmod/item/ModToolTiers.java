package net.vorrikz.firstmod.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.vorrikz.firstmod.util.ModTags;

public class ModToolTiers {
    public static final Tier ALEXANDRITE = new ForgeTier(
            1400,
            4,
            3f,
            20,
            ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL,
            () -> Ingredient.of(ModItems.ALEXANDRITE.get()),
            ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL);

    public static final Tier BISMUTH = new ForgeTier(
            2500,
            5,
            4f,
            30,
            ModTags.Blocks.NEEDS_BISMUTH_TOOL,
            () -> Ingredient.of(ModItems.BISMUTH.get()),
            ModTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL);
}
