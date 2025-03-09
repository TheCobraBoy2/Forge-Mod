package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.item.ModItems;

import java.util.concurrent.CompletableFuture;

// A class of helper functions for recipes
public abstract class RecipeUtil extends RecipeProvider {

    // This is not used
    public RecipeUtil(PackOutput p_248933_, CompletableFuture<HolderLookup.Provider> p_333797_) {
        super(p_248933_, p_333797_);
    }
    // Tools
    public static void axe(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AA ").pattern("AB ").pattern(" B ").define('A', material.get()).define('B', Items.STICK).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
    }
    public static void hoe(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AA ").pattern(" B ").pattern(" B ").define('A', material.get()).define('B', Items.STICK).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
    }
    public static void sword(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, result.get()).pattern(" A ").pattern(" A ").pattern(" B ").define('A', material.get()).define('B', Items.STICK).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
    }
    public static void pickaxe(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern("AAA").pattern(" B ").pattern(" B ").define('A', material.get()).define('B', Items.STICK).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
    }
    public static void shovel(RecipeOutput recipeOutput, RegistryObject<Item> material, RegistryObject<Item> result) {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, result.get()).pattern(" A ").pattern(" B ").pattern(" B ").define('A', material.get()).define('B', Items.STICK).unlockedBy(getHasName(material.get()), has(material.get())).save(recipeOutput);
    }


}
