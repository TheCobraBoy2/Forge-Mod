package net.vorrikz.firstmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.block.custom.AlexandriteLampBlock;
import net.vorrikz.firstmod.block.custom.HoneyBerryBushBlock;
import net.vorrikz.firstmod.block.custom.KohlrabiCropBlock;

import java.util.function.Function;

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
        blockWithItem(ModBlocks.ALEXANDRITE_END_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_NETHER_ORE);

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

        // Lamps
        customLamp(ModBlocks.ALEXANDRITE_LAMP, "alexandrite_lamp", AlexandriteLampBlock.CLICKED);

        // Crops
        makeCrop(((CropBlock)ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_crop_stage", "kohlrabi_crop_stage");

        // Bushes
        makeBush(((SweetBerryBushBlock) ModBlocks.HONEY_BERRY_BUSH.get()), "honey_berry_bush_stage", "honey_berry_bush_stage");

        // Item block json files for the ones that don't get them auto generated
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");
    }
    // Method for bushes
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for bushes
    private ConfiguredModel[] states(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(HoneyBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(HoneyBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    // Method for crops
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> states(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for crops
    private ConfiguredModel[] states(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    // Method for a lamp
    private void customLamp(RegistryObject<? extends Block> block, String name, BooleanProperty onOffState) {
        System.out.println("id = " + block.getId() + " name = " + block.get().getName());
        getVariantBuilder(block.get()).forAllStates(state -> {
            if(state.getValue(onOffState)) {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name + "_on",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + name + "_on")))};
            } else {
                return new ConfiguredModel[]{new ConfiguredModel(models().cubeAll(name + "_off",
                        ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + name + "_off")))}     ;
            }
        });
        simpleBlockItem(block.get(), models().cubeAll(name + "_on",
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + name + "_on")));
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
