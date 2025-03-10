package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.item.ModItems;
import net.vorrikz.firstmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture, CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ModTags.Items.TRANSFORMABLE_ITEMS)
                .add(ModItems.ALEXANDRITE.get())
                .add(ModItems.RAW_ALEXANDRITE.get())
                .add(Items.STICK)
                .add(Items.COMPASS)
                .add(Items.COAL);
        tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.ALEXANDRITE_HELMET.get())
                .add(ModItems.ALEXANDRITE_CHESTPLATE.get())
                .add(ModItems.ALEXANDRITE_LEGGINGS.get())
                .add(ModItems.ALEXANDRITE_BOOTS.get())

                .add(ModItems.BISMUTH_HELMET.get())
                .add(ModItems.BISMUTH_CHESTPLATE.get())
                .add(ModItems.BISMUTH_LEGGINGS.get())
                .add(ModItems.BISMUTH_BOOTS.get());
        tag(ItemTags.SWORDS)
                .add(ModItems.ALEXANDRITE_SWORD.get())
                .add(ModItems.BISMUTH_SWORD.get());
        tag(ItemTags.AXES)
                .add(ModItems.ALEXANDRITE_AXE.get())
                .add(ModItems.BISMUTH_AXE.get());
        tag(ItemTags.SHOVELS)
                .add(ModItems.ALEXANDRITE_SHOVEL.get())
                .add(ModItems.BISMUTH_SHOVEL.get());
        tag(ItemTags.HOES)
                .add(ModItems.ALEXANDRITE_HOE.get())
                .add(ModItems.BISMUTH_HOE.get());
        tag(ItemTags.PICKAXES)
                .add(ModItems.ALEXANDRITE_PICKAXE.get())
                .add(ModItems.ALEXANDRITE_HAMMER.get())
                .add(ModItems.BISMUTH_PICKAXE.get())
                .add(ModItems.BISMUTH_HAMMER.get());
        tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.WALNUT_LOG.get().asItem())
                .add(ModBlocks.WALNUT_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem());
        tag(ItemTags.LOGS)
                .add(ModBlocks.WALNUT_LOG.get().asItem())
                .add(ModBlocks.WALNUT_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_WALNUT_WOOD.get().asItem());
        tag(ItemTags.PLANKS)
                .add(ModBlocks.WALNUT_PLANKS.get().asItem());
    }
}
