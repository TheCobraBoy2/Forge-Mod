package net.vorrikz.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        // Non blocks
        stairsBlock(ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        // Redstone related
        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        // Fences / Walls
        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock(ModBlocks.ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        // Doors
        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get(), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), modLoc("block/alexandrite_trapdoor"), true, "cutout");

        // Item block json files for the ones that don't get them auto generated
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");
    }
    // Helper method to load a block with an item
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        var object = blockRegistryObject.get();
        simpleBlockWithItem(object, cubeAll(object));
    }

    // Helper method for item block json files
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject) {
        var object = blockRegistryObject.get();
        simpleBlockItem(object, new ModelFile.UncheckedModelFile("firstmod:block/" +
                ForgeRegistries.BLOCKS.getKey(object).getPath()));
    }
    // Helper method for item block json files
    private void blockItem(RegistryObject<? extends Block> blockRegistryObject, String appendix) {
        var object = blockRegistryObject.get();
        simpleBlockItem(object, new ModelFile.UncheckedModelFile("firstmod:block/" +
                ForgeRegistries.BLOCKS.getKey(object).getPath() + appendix));
    }
}
