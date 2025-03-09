package net.vorrikz.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // Regular items
        basicItem(ModItems.ALEXANDRITE.get());
        basicItem(ModItems.RAW_ALEXANDRITE.get());

        // Fuels
        basicItem(ModItems.AURORA_ASHES.get());

        // Foods
        basicItem(ModItems.KOHLRABI.get());

        // Advanced items
        basicItem(ModItems.CHISEL.get());
    }
}
