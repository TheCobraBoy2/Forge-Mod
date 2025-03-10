package net.vorrikz.firstmod.datagen;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.block.custom.KohlrabiCropBlock;
import net.vorrikz.firstmod.block.custom.RadishCropBlock;
import net.vorrikz.firstmod.item.ModItems;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider pRegistries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), pRegistries);
    }

    @Override
    protected void generate() {
        // Set drop tables for blocks that only drop themselves
        this.dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());
        this.dropSelf(ModBlocks.MAGIC_BLOCK.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_STAIRS.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_BUTTON.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_FENCE.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_FENCE_GATE.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_WALL.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_TRAPDOOR.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_LAMP.get());
        this.dropSelf(ModBlocks.WALNUT_LOG.get());
        this.dropSelf(ModBlocks.WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WALNUT_LOG.get());
        this.dropSelf(ModBlocks.WALNUT_SAPLING.get());
        this.dropSelf(ModBlocks.WALNUT_PLANKS.get());
        this.dropSelf(ModBlocks.BISMUTH_BLOCK.get());
        this.dropSelf(ModBlocks.BISMUTH_FENCE.get());
        this.dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
        this.dropSelf(ModBlocks.BISMUTH_BUTTON.get());
        this.dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.BISMUTH_STAIRS.get());
        this.dropSelf(ModBlocks.BISMUTH_WALL.get());
        this.dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
        this.dropSelf(ModBlocks.BISMUTH_LAMP.get());


        // Add drop tables for blocks that don't drop themselves
        this.add(ModBlocks.ALEXANDRITE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 1, 2));
        this.add(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 3, 7));
        this.add(ModBlocks.ALEXANDRITE_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_END_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 5, 8));
        this.add(ModBlocks.ALEXANDRITE_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.ALEXANDRITE_NETHER_ORE.get(), ModItems.RAW_ALEXANDRITE.get(), 1, 6));

        this.add(ModBlocks.BISMUTH_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_ORE.get(), ModItems.RAW_BISMUTH.get(), 1, 2));
        this.add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), ModItems.RAW_BISMUTH.get(), 3, 7));
        this.add(ModBlocks.BISMUTH_END_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_END_ORE.get(), ModItems.RAW_BISMUTH.get(), 5, 8));
        this.add(ModBlocks.BISMUTH_NETHER_ORE.get(),
                block -> createMultipleOreDrops(ModBlocks.BISMUTH_NETHER_ORE.get(), ModItems.RAW_BISMUTH.get(), 1, 6));

        this.add(ModBlocks.ALEXANDRITE_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.ALEXANDRITE_SLAB.get()));

        this.add(ModBlocks.ALEXANDRITE_DOOR.get(),
                block -> createDoorTable(ModBlocks.ALEXANDRITE_DOOR.get()));

        this.add(ModBlocks.BISMUTH_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));

        this.add(ModBlocks.BISMUTH_DOOR.get(),
                block -> createDoorTable(ModBlocks.BISMUTH_DOOR.get()));

        // Add drop tables for blocks with conditions
        this.add(ModBlocks.KOHLRABI_CROP.get(), this.createCropDrops(ModBlocks.KOHLRABI_CROP.get(),
                ModItems.KOHLRABI.get(), ModItems.KOHLRABI_SEEDS.get(), cropCondtionBuilder(ModBlocks.KOHLRABI_CROP.get(), KohlrabiCropBlock.AGE, KohlrabiCropBlock.MAX_AGE)));

        this.add(ModBlocks.RADISH_CROP.get(), this.createCropDrops(ModBlocks.RADISH_CROP.get(),
                ModItems.RADISH.get(), ModItems.RADISH_SEEDS.get(), cropCondtionBuilder(ModBlocks.RADISH_CROP.get(), RadishCropBlock.AGE, RadishCropBlock.MAX_AGE)));

        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.m_255025_(Registries.ENCHANTMENT);
        this.add(ModBlocks.HONEY_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.HONEY_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.HONEY_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.HONEY_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));
        this.add(ModBlocks.GOJI_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
                                ).add(LootItem.lootTableItem(ModItems.GOJI_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                ).withPool(LootPool.lootPool().when(
                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
                                ).add(LootItem.lootTableItem(ModItems.GOJI_BERRIES.get()))
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )));

        this.add(ModBlocks.WALNUT_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.WALNUT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    // Helper method for crops
    private static LootItemCondition.Builder cropCondtionBuilder(Block block, IntegerProperty age, int maxAge) {
        return LootItemBlockStatePropertyCondition.hasBlockStateProperties(block)
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(age, maxAge));
    }

    // Helper method for ore drops with multiple items
    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.m_255025_(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(
                pBlock, this.applyExplosionDecay(
                        pBlock, LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                                .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
                )
        );
    }

    // Make all ModBlocks retrievable for this class
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
