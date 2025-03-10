package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.item.ModItems;
import net.minecraft.world.item.crafting.*;
import org.spongepowered.asm.mixin.MixinEnvironment;


import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(packOutput, completableFuture);
    }

    // My version of parchment doesn't have this, but it is the buildRecipes method
    @Override
    protected void m_245200_(RecipeOutput recipeOutput) {
        // Shaped recipes
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), RecipeCategory.MISC, ModBlocks.ALEXANDRITE_BLOCK.get());
        stairBuilder(ModBlocks.ALEXANDRITE_STAIRS.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_SLAB.get(), ModItems.ALEXANDRITE.get());
        buttonBuilder(ModBlocks.ALEXANDRITE_BUTTON.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get(), ModItems.ALEXANDRITE.get());
        fenceBuilder(ModBlocks.ALEXANDRITE_FENCE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.ALEXANDRITE_FENCE_GATE.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.ALEXANDRITE_WALL.get(), ModItems.ALEXANDRITE.get());
        doorBuilder(ModBlocks.ALEXANDRITE_DOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);
        trapdoorBuilder(ModBlocks.ALEXANDRITE_TRAPDOOR.get(), Ingredient.of(ModItems.ALEXANDRITE.get())).group("alexandrite")
                .unlockedBy(getHasName(ModItems.ALEXANDRITE.get()), has(ModItems.ALEXANDRITE.get()))
                .save(recipeOutput);

        nineBlockStorageRecipes(recipeOutput, RecipeCategory.MISC, ModItems.BISMUTH.get(), RecipeCategory.MISC, ModBlocks.BISMUTH_BLOCK.get());
        stairBuilder(ModBlocks.BISMUTH_STAIRS.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_SLAB.get(), ModItems.BISMUTH.get());
        buttonBuilder(ModBlocks.BISMUTH_BUTTON.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
        pressurePlate(recipeOutput, ModBlocks.BISMUTH_PRESSURE_PLATE.get(), ModItems.BISMUTH.get());
        fenceBuilder(ModBlocks.BISMUTH_FENCE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
        fenceGateBuilder(ModBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BISMUTH_WALL.get(), ModItems.BISMUTH.get());
        doorBuilder(ModBlocks.BISMUTH_DOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);
        trapdoorBuilder(ModBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(ModItems.BISMUTH.get())).group("bismuth")
                .unlockedBy(getHasName(ModItems.BISMUTH.get()), has(ModItems.BISMUTH.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("CAC")
                .pattern("ABA")
                .pattern("CAC")
                .define('A', ModBlocks.ALEXANDRITE_BLOCK.get())
                .define('B', ModItems.CHISEL.get())
                .define('C', ModBlocks.BISMUTH_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(recipeOutput);
        RecipeUtil.axe(recipeOutput, ModItems.ALEXANDRITE.get(), Items.STICK, ModItems.ALEXANDRITE_AXE);
        RecipeUtil.hoe(recipeOutput, ModItems.ALEXANDRITE.get(), Items.STICK, ModItems.ALEXANDRITE_HOE);
        RecipeUtil.pickaxe(recipeOutput, ModItems.ALEXANDRITE.get(), Items.STICK, ModItems.ALEXANDRITE_PICKAXE);
        RecipeUtil.sword(recipeOutput, ModItems.ALEXANDRITE.get(), Items.STICK, ModItems.ALEXANDRITE_SWORD);
        RecipeUtil.shovel(recipeOutput, ModItems.ALEXANDRITE.get(), Items.STICK, ModItems.ALEXANDRITE_SHOVEL);
        RecipeUtil.hammer(recipeOutput, ModItems.ALEXANDRITE.get(), ModBlocks.ALEXANDRITE_BLOCK.get(), Items.BREEZE_ROD, ModItems.ALEXANDRITE_HAMMER);
        RecipeUtil.helmet(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_HELMET);
        RecipeUtil.chestplate(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_CHESTPLATE);
        RecipeUtil.leggings(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_LEGGINGS);
        RecipeUtil.boots(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_BOOTS);
        RecipeUtil.axe(recipeOutput, ModItems.BISMUTH.get(), Items.STICK, ModItems.BISMUTH_AXE);
        RecipeUtil.hoe(recipeOutput, ModItems.BISMUTH.get(), Items.STICK, ModItems.BISMUTH_HOE);
        RecipeUtil.pickaxe(recipeOutput, ModItems.BISMUTH.get(), Items.STICK, ModItems.BISMUTH_PICKAXE);
        RecipeUtil.sword(recipeOutput, ModItems.BISMUTH.get(), Items.STICK, ModItems.BISMUTH_SWORD);
        RecipeUtil.shovel(recipeOutput, ModItems.BISMUTH.get(), Items.STICK, ModItems.BISMUTH_SHOVEL);
        RecipeUtil.hammer(recipeOutput, ModItems.BISMUTH.get(), ModBlocks.BISMUTH_BLOCK.get(), Items.BLAZE_ROD, ModItems.BISMUTH_HAMMER);
        RecipeUtil.helmet(recipeOutput, ModItems.BISMUTH, ModItems.BISMUTH_HELMET);
        RecipeUtil.chestplate(recipeOutput, ModItems.BISMUTH, ModItems.BISMUTH_CHESTPLATE);
        RecipeUtil.leggings(recipeOutput, ModItems.BISMUTH, ModItems.BISMUTH_LEGGINGS);
        RecipeUtil.boots(recipeOutput, ModItems.BISMUTH, ModItems.BISMUTH_BOOTS);

        RecipeUtil.bow(recipeOutput, Items.BREEZE_ROD, ModItems.ALEXANDRITE.get(), Items.STRING, ModItems.VORRIK_BOW);

        // Shapeless recipes
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
//                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(recipeOutput);
//
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
//                .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
//                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())).save(recipeOutput);

        RecipeUtil.plank(ModBlocks.WALNUT_LOG.get(), ModBlocks.WALNUT_PLANKS).save(recipeOutput, FirstMod.MOD_ID + ":walnut_plank_from_walnut_log");
        RecipeUtil.plank(ModBlocks.WALNUT_WOOD.get(), ModBlocks.WALNUT_PLANKS).save(recipeOutput, FirstMod.MOD_ID + ":walnut_plank_from_walnut_wood");
        RecipeUtil.plank(ModBlocks.STRIPPED_WALNUT_LOG.get(), ModBlocks.WALNUT_PLANKS).save(recipeOutput, FirstMod.MOD_ID + ":walnut_plank_from_stripped_walnut_log");
        RecipeUtil.plank(ModBlocks.STRIPPED_WALNUT_WOOD.get(), ModBlocks.WALNUT_PLANKS).save(recipeOutput, FirstMod.MOD_ID + ":walnut_plank_from_stripped_walnut_wood");


        // Lists for items that can be smelted / blasted
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(),
                ModBlocks.ALEXANDRITE_NETHER_ORE.get(), ModBlocks.ALEXANDRITE_END_ORE.get());
        List<ItemLike> BISMUTH_SMELTABLES = List.of(ModItems.RAW_BISMUTH.get(),
                ModBlocks.BISMUTH_ORE.get(), ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                ModBlocks.BISMUTH_NETHER_ORE.get(), ModBlocks.BISMUTH_END_ORE.get());

        // Smelting
        oreSmelting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");

        oreSmelting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.4f, 300, "bismuth");

        // Blasting
        oreBlasting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");

        oreBlasting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.BISMUTH.get(), 0.4f, 150, "bismuth");
    }

    // Helper method for ore smelting recipe generation
    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    // Helper method for ore blasting recipe generation
    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    // Helper method for ore cooking recipe generation this is used in the oreBlasting and oreSmelting methods
    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, FirstMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }

    // A class of helper functions for the recipes
    public abstract static class RecipeUtil extends RecipeProvider {

        // This is not used
        public RecipeUtil(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> p_333797_) {
            super(p_248933_, p_333797_);
        }
        // Tools
        public static void axe(RecipeOutput recipeOutput, Item material, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AA ").pattern("AB ").pattern(" B ").define('A', material).define('B', materialHandle).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
        }
        public static void hoe(RecipeOutput recipeOutput, Item material, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AA ").pattern(" B ").pattern(" B ").define('A', material).define('B', materialHandle).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
        }
        public static void sword(RecipeOutput recipeOutput, Item material, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern(" A ").pattern(" A ").pattern(" B ").define('A', material).define('B', materialHandle).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
        }
        public static void pickaxe(RecipeOutput recipeOutput, Item material, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AAA").pattern(" B ").pattern(" B ").define('A', material).define('B', materialHandle).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
        }
        public static void shovel(RecipeOutput recipeOutput, Item material, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern(" A ").pattern(" B ").pattern(" B ").define('A', material).define('B', materialHandle).unlockedBy(getHasName(material), has(material)).save(recipeOutput);
        }
        public static void hammer(RecipeOutput recipeOutput, Item materialItem, Block materialBlock, Item materialHandle, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("ABA").pattern("ABA").pattern(" C ").define('A', materialItem).define('B', materialBlock).define('C', materialHandle).unlockedBy(getHasName(materialBlock), has(materialBlock)).save(recipeOutput);
        }
        public static void helmet(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern("AAA").pattern("A A").pattern("   ").define('A', material.get()).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
        }
        public static void chestplate(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern("A A").pattern("AAA").pattern("AAA").define('A', material.get()).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
        }
        public static void leggings(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern("AAA").pattern("A A").pattern("A A").define('A', material.get()).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
        }
        public static void boots(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern("A A").pattern("A A").define('A', material.get()).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
        }
        public static void bow(RecipeOutput recipeOutput, Item handleMaterial, Item SideMaterial, Item BowString, RegistryObject<Item> result) {
            ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern(" BC").pattern("A C").pattern(" BC").define('A', handleMaterial).define('B', SideMaterial).define('C', BowString).unlockedBy(getHasName(SideMaterial), has(SideMaterial)).save(recipeOutput);
        }
        public static ShapelessRecipeBuilder plank(Block wood, RegistryObject<Block> plank) {
            return ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, plank.get(), 4).requires(wood).unlockedBy(getHasName(wood), has(wood));
        }
    }
}
