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
import net.vorrikz.firstmod.block.custom.*;

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

        blockWithItem(ModBlocks.BISMUTH_BLOCK);

        // Ores
        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_END_ORE);
        blockWithItem(ModBlocks.ALEXANDRITE_NETHER_ORE);

        blockWithItem(ModBlocks.BISMUTH_ORE);
        blockWithItem(ModBlocks.BISMUTH_DEEPSLATE_ORE);
        blockWithItem(ModBlocks.BISMUTH_END_ORE);
        blockWithItem(ModBlocks.BISMUTH_NETHER_ORE);

        // Advanced blocks
        blockWithItem(ModBlocks.MAGIC_BLOCK);

        // Non blocks
        stairsBlock(ModBlocks.ALEXANDRITE_STAIRS.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        slabBlock(ModBlocks.ALEXANDRITE_SLAB.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        stairsBlock(ModBlocks.BISMUTH_STAIRS.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        slabBlock(ModBlocks.BISMUTH_SLAB.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        // Redstone related
        buttonBlock(ModBlocks.ALEXANDRITE_BUTTON.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        pressurePlateBlock(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        buttonBlock(ModBlocks.BISMUTH_BUTTON.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        pressurePlateBlock(ModBlocks.BISMUTH_PRESSURE_PLATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        // Fences / Walls
        fenceBlock(ModBlocks.ALEXANDRITE_FENCE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        fenceGateBlock(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));
        wallBlock(ModBlocks.ALEXANDRITE_WALL.get(), blockTexture(ModBlocks.ALEXANDRITE_BLOCK.get()));

        fenceBlock(ModBlocks.BISMUTH_FENCE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        fenceGateBlock(ModBlocks.BISMUTH_FENCE_GATE.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));
        wallBlock(ModBlocks.BISMUTH_WALL.get(), blockTexture(ModBlocks.BISMUTH_BLOCK.get()));

        // Doors
        doorBlockWithRenderType(ModBlocks.ALEXANDRITE_DOOR.get(), modLoc("block/alexandrite_door_bottom"), modLoc("block/alexandrite_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), modLoc("block/alexandrite_trapdoor"), true, "cutout");

        doorBlockWithRenderType(ModBlocks.BISMUTH_DOOR.get(), modLoc("block/bismuth_door_bottom"), modLoc("block/bismuth_door_top"), "cutout");
        trapdoorBlockWithRenderType(ModBlocks.BISMUTH_TRAPDOOR.get(), modLoc("block/bismuth_trapdoor"), true, "cutout");

        // Lamps
        customLamp(ModBlocks.ALEXANDRITE_LAMP, "alexandrite_lamp", AlexandriteLampBlock.CLICKED);

        customLamp(ModBlocks.BISMUTH_LAMP, "bismuth_lamp", BismuthLampBlock.CLICKED);

        // Crops
        makeCrop(((CropBlock)ModBlocks.KOHLRABI_CROP.get()), "kohlrabi_crop_stage", "kohlrabi_crop_stage");

        makeCropR(((CropBlock)ModBlocks.RADISH_CROP.get()), "radish_crop_stage", "radish_crop_stage");

        // Bushes
        makeBush(((SweetBerryBushBlock) ModBlocks.HONEY_BERRY_BUSH.get()), "honey_berry_bush_stage", "honey_berry_bush_stage");

        makeBush(((SweetBerryBushBlock) ModBlocks.GOJI_BERRY_BUSH.get()), "goji_berry_bush_stage", "goji_berry_bush_stage");

        // Logs
        logBlock(ModBlocks.WALNUT_LOG.get());
        logBlock(ModBlocks.STRIPPED_WALNUT_LOG.get());

        // Wood
        axisBlock(ModBlocks.WALNUT_WOOD.get(), blockTexture(ModBlocks.WALNUT_LOG.get()), blockTexture(ModBlocks.WALNUT_LOG.get()));
        axisBlock(ModBlocks.STRIPPED_WALNUT_WOOD.get(), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()), blockTexture(ModBlocks.STRIPPED_WALNUT_LOG.get()));

        // Planks
        blockWithItem(ModBlocks.WALNUT_PLANKS);

        // Leaves
        leavesBlock(ModBlocks.WALNUT_LEAVES);

        // Saplings
        saplingBlock(ModBlocks.WALNUT_SAPLING);

        // Item block json files for the ones that don't get them auto generated
        blockItem(ModBlocks.ALEXANDRITE_STAIRS);
        blockItem(ModBlocks.ALEXANDRITE_SLAB);
        blockItem(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
        blockItem(ModBlocks.ALEXANDRITE_FENCE_GATE);
        blockItem(ModBlocks.ALEXANDRITE_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.BISMUTH_STAIRS);
        blockItem(ModBlocks.BISMUTH_SLAB);
        blockItem(ModBlocks.BISMUTH_PRESSURE_PLATE);
        blockItem(ModBlocks.BISMUTH_FENCE_GATE);
        blockItem(ModBlocks.BISMUTH_TRAPDOOR, "_bottom");
        blockItem(ModBlocks.WALNUT_LOG);
        blockItem(ModBlocks.WALNUT_WOOD);
        blockItem(ModBlocks.STRIPPED_WALNUT_LOG);
        blockItem(ModBlocks.STRIPPED_WALNUT_WOOD);
    }
    // Method for saplings
    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    // Method for leaves
    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    // Method for bushes
    public void makeBush(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesH(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for bushes
    private ConfiguredModel[] statesH(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(HoneyBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(HoneyBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    // Method for bushes
    public void makeBushG(SweetBerryBushBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesG(state, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for bushes
    private ConfiguredModel[] statesG(BlockState state, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().cross(modelName + state.getValue(GojiBerryBushBlock.AGE),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(GojiBerryBushBlock.AGE))).renderType("cutout"));

        return models;
    }

    // Method for crops
    public void makeCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesK(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for crops
    private ConfiguredModel[] statesK(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(((KohlrabiCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }

    // Method for crops
    public void makeCropR(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> statesR(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    // Helper method for crops
    private ConfiguredModel[] statesR(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((RadishCropBlock) block).getAgeProperty()),
                ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, "block/" + textureName + state.getValue(((RadishCropBlock) block).getAgeProperty()))).renderType("cutout"));

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
