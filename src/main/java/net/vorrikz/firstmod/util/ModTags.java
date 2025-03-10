package net.vorrikz.firstmod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.vorrikz.firstmod.FirstMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_ALEXANDRITE_TOOL = createTag("needs_alexandrite_tool");
        public static final TagKey<Block> INCORRECT_FOR_ALEXANDRITE_TOOL = createTag("incorrect_for_alexandrite_tool");

        public static final TagKey<Block> NEEDS_BISMUTH_TOOL = createTag("needs_bismuth_tool");
        public static final TagKey<Block> INCORRECT_FOR_BISMUTH_TOOL = createTag("incorrect_for_bismuth_tool");

        // Helper method for creating a tag for a block
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        // Helper method for creating a tag for an item
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FirstMod.MOD_ID, name));
        }
    }
}
