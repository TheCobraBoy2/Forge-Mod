package net.vorrikz.firstmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.vorrikz.firstmod.block.ModBlocks;
import net.vorrikz.firstmod.component.ModDataComponentTypes;
import net.vorrikz.firstmod.effect.ModEffects;
import net.vorrikz.firstmod.enchantment.ModEnchantmentEffects;
import net.vorrikz.firstmod.enchantment.ModEnchantments;
import net.vorrikz.firstmod.item.ModCreativeModeTabs;
import net.vorrikz.firstmod.item.ModItems;
import net.vorrikz.firstmod.potion.ModPotions;
import net.vorrikz.firstmod.sound.ModSounds;
import net.vorrikz.firstmod.util.ModItemProperties;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FirstMod.MOD_ID)
public class FirstMod {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "firstmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public FirstMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the mods creative mode tabs
        ModCreativeModeTabs.register(modEventBus);

        // Register the mods items with the event bus
        ModItems.register(modEventBus);
        // Register the mods blocks with the event bus
        ModBlocks.register(modEventBus);

        // Register the data component types with the event bus
        ModDataComponentTypes.register(modEventBus);

        // Register the sounds with the event bus
        ModSounds.register(modEventBus);

        // Register the effects with the event bus
        ModEffects.register(modEventBus);
        // Register the potions with the event bus
        ModPotions.register(modEventBus);

        // Register the enchantment effects with the event bus
        ModEnchantmentEffects.register(modEventBus);

        // Register the items to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add items to vanilla creative mode tabs
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.ALEXANDRITE);
            event.accept(ModItems.RAW_ALEXANDRITE);
            event.accept(ModItems.AURORA_ASHES);
        }

        if (event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.KOHLRABI);
        }

        if (event.getTabKey() == CreativeModeTabs.OP_BLOCKS) {
            event.accept(ModBlocks.MAGIC_BLOCK.get());
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_ORE);
            event.accept(ModBlocks.ALEXANDRITE_DEEPSLATE_ORE);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.CHISEL);
            event.accept(ModItems.ALEXANDRITE_PICKAXE);
            event.accept(ModItems.ALEXANDRITE_AXE);
            event.accept(ModItems.ALEXANDRITE_HOE);
            event.accept(ModItems.ALEXANDRITE_SHOVEL);
            event.accept(ModItems.ALEXANDRITE_HAMMER);
            event.accept(ModItems.BAR_BRAWL_MUSIC_DISC);
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_BUTTON);
            event.accept(ModBlocks.ALEXANDRITE_PRESSURE_PLATE);
            event.accept(ModBlocks.ALEXANDRITE_DOOR);
        }

        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_WALL);
            event.accept(ModBlocks.ALEXANDRITE_DOOR);
            event.accept(ModBlocks.ALEXANDRITE_TRAPDOOR);
            event.accept(ModBlocks.ALEXANDRITE_FENCE);
            event.accept(ModBlocks.ALEXANDRITE_FENCE_GATE);
            event.accept(ModBlocks.ALEXANDRITE_STAIRS);
            event.accept(ModBlocks.ALEXANDRITE_SLAB);
            event.accept(ModBlocks.ALEXANDRITE_LAMP);
            event.accept(ModBlocks.ALEXANDRITE_LAMP);
            event.accept(ModBlocks.ALEXANDRITE_BLOCK);
            event.accept(ModBlocks.RAW_ALEXANDRITE_BLOCK);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            event.accept(ModBlocks.ALEXANDRITE_LAMP);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(ModItems.ALEXANDRITE_SWORD);

            event.accept(ModItems.ALEXANDRITE_BOOTS);
            event.accept(ModItems.ALEXANDRITE_HELMET);
            event.accept(ModItems.ALEXANDRITE_LEGGINGS);
            event.accept(ModItems.ALEXANDRITE_CHESTPLATE);

            event.accept(ModItems.ALEXANDRITE_HORSE_AROMOR);

            event.accept(ModItems.VORRIK_BOW);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
        }
    }
}
