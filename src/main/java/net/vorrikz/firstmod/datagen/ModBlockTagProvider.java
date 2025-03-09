package net.vorrikz.firstmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FirstMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // Add the blocks that should be mineable only with pickaxe to the MINEABLE_WITH_PICKAXE tag
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(ModBlocks.ALEXANDRITE_DOOR.get())
                .add(ModBlocks.ALEXANDRITE_FENCE.get())
                .add(ModBlocks.ALEXANDRITE_WALL.get())
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get())
                .add(ModBlocks.ALEXANDRITE_STAIRS.get())
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get())
                .add(ModBlocks.ALEXANDRITE_BUTTON.get())
                .add(ModBlocks.ALEXANDRITE_TRAPDOOR.get())
                .add(ModBlocks.ALEXANDRITE_LAMP.get())
                .add(ModBlocks.MAGIC_BLOCK.get());

        // Add the blocks mineable only with a diamond tool to the NEEDS_DIAMOND_TOOL tag
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
        // Add the blocks mineable only with an iron tool to the NEEDS_IRON_TOOL tag
        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.ALEXANDRITE_ORE.get())
                .add(ModBlocks.RAW_ALEXANDRITE_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_DOOR.get())
                .add(ModBlocks.ALEXANDRITE_FENCE.get())
                .add(ModBlocks.ALEXANDRITE_WALL.get())
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get())
                .add(ModBlocks.ALEXANDRITE_STAIRS.get())
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get())
                .add(ModBlocks.ALEXANDRITE_BUTTON.get())
                .add(ModBlocks.ALEXANDRITE_TRAPDOOR.get())
                .add(ModBlocks.ALEXANDRITE_LAMP.get())
                .add(ModBlocks.ALEXANDRITE_BLOCK.get());
        // Add the blocks that an iron tool cant mine but an alexandrite one can
        tag(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL)
                .add(ModBlocks.MAGIC_BLOCK.get())
                .add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get())
                .add(Blocks.OBSIDIAN)
                .addTag(BlockTags.NEEDS_IRON_TOOL);
        // Ensure all blocks not listed above and can't be mined by iron tools cant be mined by alexandrite tools
        tag(ModTags.Blocks.INCORRECT_FOR_ALEXANDRITE_TOOL)
                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
                .remove(ModTags.Blocks.NEEDS_ALEXANDRITE_TOOL);
        // Add the fences to the FENCES tag
        tag(BlockTags.FENCES)
                .add(ModBlocks.ALEXANDRITE_FENCE.get());
        // Add the fence gates to the FENCE_GATES tag
        tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
        // Add the walls to the WALLS tag
        tag(BlockTags.WALLS)
                .add(ModBlocks.ALEXANDRITE_WALL.get());
        // Add the doors to the DOORS tag
        tag(BlockTags.DOORS)
                .add(ModBlocks.ALEXANDRITE_DOOR.get());
        // Add the trapdoors to the TRAPDOORS tag
        tag(BlockTags.TRAPDOORS)
                .add(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
        // Add the buttons to the BUTTONS tag
        tag(BlockTags.BUTTONS)
                .add(ModBlocks.ALEXANDRITE_BUTTON.get());
        // Add the pressure plates to the PRESSURE_PLATES tag
        tag(BlockTags.PRESSURE_PLATES)
                .add(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
        // Add the stairs to the STAIRS tag
        tag(BlockTags.STAIRS)
                .add(ModBlocks.ALEXANDRITE_STAIRS.get());
        // Add the slabs to the SLABS tag
        tag(BlockTags.SLABS)
                .add(ModBlocks.ALEXANDRITE_SLAB.get());
    }
}
