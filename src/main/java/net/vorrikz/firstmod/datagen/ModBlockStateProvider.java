package net.vorrikz.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FirstMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        // Regular blocks
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.RAW_ALEXANDRITE_BLOCK);

        // Ores
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);

        // Advanced blocks
        blockWithItem(ModBlocks.MAGIC_BLOCK);
    }
    // Helper method to load a block with an item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        var object = blockRegistryObject.get();
        simpleBlockWithItem(object, cubeAll(object));
    }
}
