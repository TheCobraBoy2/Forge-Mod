package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.fml.common.Mod;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.item.ModItems;
import net.minecraft.world.item.crafting.*;


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
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MAGIC_BLOCK.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModBlocks.ALEXANDRITE_BLOCK.get())
                .define('B', ModItems.CHISEL.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(recipeOutput);
        RecipeUtil.axe(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_AXE);
        RecipeUtil.hoe(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_HOE);
        RecipeUtil.pickaxe(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_PICKAXE);
        RecipeUtil.sword(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_SWORD);
        RecipeUtil.shovel(recipeOutput, ModItems.ALEXANDRITE, ModItems.ALEXANDRITE_SHOVEL);

        // Shapeless recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 9)
                .requires(ModBlocks.ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_ALEXANDRITE.get(), 9)
                .requires(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_ALEXANDRITE_BLOCK.get()), has(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 32)
                .requires(ModBlocks.MAGIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.ALEXANDRITE_BLOCK.get()), has(ModBlocks.ALEXANDRITE_BLOCK.get()))
                .save(recipeOutput, FirstMod.MOD_ID + ":alexandrite_from_magic_block");

        // Lists for items that can be smelted / blasted
        List<ItemLike> ALEXANDRITE_SMELTABLES = List.of(ModItems.RAW_ALEXANDRITE.get(),
                ModBlocks.ALEXANDRITE_ORE.get(), ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

        // Smelting
        oreSmelting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 200, "alexandrite");
        // Blasting
        oreBlasting(recipeOutput, ALEXANDRITE_SMELTABLES, RecipeCategory.MISC, ModItems.ALEXANDRITE.get(), 0.25f, 100, "alexandrite");
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
}
