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

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FirstMod.MOD_ID);

    // Add creative mode tabs to the DeferredRegister
    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_ITEMS_TAB = CREATIVE_MODE_TABS.register("alexandrite_items_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModItems.CHISEL.get()))
                    .title(Component.translatable("creativetab.firstmod.alexandrite_items"))
                    // Add items to the custom ALEXANDRITE_ITEMS_TAB creative tab
                    .displayItems((itemDisplayParameters, output) -> {
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

                        output.accept(ModItems.VORRIK_BOW.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> ALEXANDRITE_BLOCKS_TAB = CREATIVE_MODE_TABS.register("alexandrite_blocks_tab",
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.ALEXANDRITE_BLOCK.get()))
                    .withTabsBefore(ALEXANDRITE_ITEMS_TAB.getId())
                    .title(Component.translatable("creativetab.firstmod.alexandrite_blocks"))
                    // Add blocks to the custom ALEXANDRITE_BLOCKS_TAB creative tab
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        output.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK.get());

                        output.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        output.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE.get());

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
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
