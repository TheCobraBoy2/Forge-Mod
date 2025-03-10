package net.vorrikz.firstmod.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower WALNUT = new TreeGrower(FirstMod.MOD_ID + ":walnut",
            Optional.empty(), Optional.of(ModConfiguredFeatures.WALNUT_KEY), Optional.empty());
}
