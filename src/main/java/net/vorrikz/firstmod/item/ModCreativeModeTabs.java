package net.vorrikz.firstmod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.potion.ModPotions;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    // Add creative mode tabs to the DeferredRegister
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHISEL.get()))
                    .title(Component.translatable("creativetab.firstmod.first_mod"))
                    // Add items and blocks to the custom first_mod creative tab
                    .displayItems((itemDisplayParameters, output) -> {

                        // Items
                        output.accept(ModItems.CHISEL.get());

                        output.accept(ModItems.ALEXANDRITE.get());
                        output.accept(ModItems.RAW_ALEXANDRITE.get());

                        output.accept(ModItems.KOHLRABI.get());

                        output.accept(ModItems.AURORA_ASHES.get());

                        output.accept(ModItems.ALEXANDRITE_SWORD.get());
                        output.accept(ModItems.ALEXANDRITE_AXE.get());
                        output.accept(ModItems.ALEXANDRITE_HOE.get());
                        output.accept(ModItems.ALEXANDRITE_PICKAXE.get());
                        output.accept(ModItems.ALEXANDRITE_SHOVEL.get());

                        output.accept(ModItems.ALEXANDRITE_HAMMER.get());

                        output.accept(ModItems.ALEXANDRITE_BOOTS.get());
                        output.accept(ModItems.ALEXANDRITE_HELMET.get());
                        output.accept(ModItems.ALEXANDRITE_LEGGINGS.get());
                        output.accept(ModItems.ALEXANDRITE_CHESTPLATE.get());

                        output.accept(ModItems.ALEXANDRITE_HORSE_AROMOR.get());

                        output.accept(ModItems.BISMUTH.get());
                        output.accept(ModItems.RAW_BISMUTH.get());

                        output.accept(ModItems.RADISH.get());

                        output.accept(ModItems.STARLIGHT_ASHES.get());

                        output.accept(ModItems.BISMUTH_SWORD.get());
                        output.accept(ModItems.BISMUTH_AXE.get());
                        output.accept(ModItems.BISMUTH_HOE.get());
                        output.accept(ModItems.BISMUTH_PICKAXE.get());
                        output.accept(ModItems.BISMUTH_SHOVEL.get());

                        output.accept(ModItems.BISMUTH_HAMMER.get());

                        output.accept(ModItems.BISMUTH_BOOTS.get());
                        output.accept(ModItems.BISMUTH_HELMET.get());
                        output.accept(ModItems.BISMUTH_LEGGINGS.get());
                        output.accept(ModItems.BISMUTH_CHESTPLATE.get());

                        output.accept(ModItems.BISMUTH_HORSE_AROMOR.get());

                        output.accept(ModItems.VORRIK_BOW.get());

                        output.accept(ModItems.BAR_BRAWL_MUSIC_DISC.get());

                        output.accept(ModItems.KOHLRABI_SEEDS.get());

                        output.accept(ModItems.HONEY_BERRIES.get());

                        output.accept(ModItems.RADISH_SEEDS.get());

                        output.accept(ModItems.GOJI_BERRIES.get());

                        output.accept(ModItems.TRICERATOPS_SPAWN_EGG.get());


                        // Blocks
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_NETHER_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_END_ORE.get());

                        output.accept(ModBlocks.MAGIC_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_STAIRS.get());
                        output.accept(ModBlocks.ALEXANDRITE_SLAB.get());

                        output.accept(ModBlocks.ALEXANDRITE_DOOR.get());
                        output.accept(ModBlocks.ALEXANDRITE_TRAPDOOR.get());

                        output.accept(ModBlocks.ALEXANDRITE_WALL.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE.get());
                        output.accept(ModBlocks.ALEXANDRITE_FENCE_GATE.get());

                        output.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.ALEXANDRITE_BUTTON.get());

                        output.accept(ModBlocks.ALEXANDRITE_LAMP.get());

                        output.accept(ModBlocks.BISMUTH_BLOCK.get());

                        output.accept(ModBlocks.BISMUTH_ORE.get());
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE.get());
                        output.accept(ModBlocks.BISMUTH_NETHER_ORE.get());
                        output.accept(ModBlocks.BISMUTH_END_ORE.get());

                        output.accept(ModBlocks.BISMUTH_STAIRS.get());
                        output.accept(ModBlocks.BISMUTH_SLAB.get());

                        output.accept(ModBlocks.BISMUTH_DOOR.get());
                        output.accept(ModBlocks.BISMUTH_TRAPDOOR.get());

                        output.accept(ModBlocks.BISMUTH_WALL.get());
                        output.accept(ModBlocks.BISMUTH_FENCE.get());
                        output.accept(ModBlocks.BISMUTH_FENCE_GATE.get());

                        output.accept(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.BISMUTH_BUTTON.get());

                        output.accept(ModBlocks.BISMUTH_LAMP.get());

                        output.accept(ModBlocks.WALNUT_LEAVES.get());
                        output.accept(ModBlocks.WALNUT_SAPLING.get());
                        output.accept(ModBlocks.WALNUT_PLANKS.get());
                        output.accept(ModBlocks.WALNUT_LOG.get());
                        output.accept(ModBlocks.WALNUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_WALNUT_LOG.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
