package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.enchantment.ModEnchantments;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModDataPackEntries extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.ENCHANTMENT, ModEnchantments::bootstrap);

    public ModDataPackEntries(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER , Set.of(FirstMod.MOD_ID));
    }
}
