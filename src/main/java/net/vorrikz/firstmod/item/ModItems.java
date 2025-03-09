package net.vorrikz.firstmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.vorrikz.firstmod.FirstMod;
import net.vorrikz.firstmod.item.custom.FuelItem;
import net.vorrikz.firstmod.item.custom.ChiselItem;
import net.vorrikz.firstmod.item.custom.HammerItem;
import net.vorrikz.firstmod.item.custom.ModArmorItem;

import java.util.List;

public class ModItems {
    // Create the register for the items
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FirstMod.MOD_ID);


    // Add items to the DeferredRegister
    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ALEXANDRITE = ITEMS.register("raw_alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHISEL = ITEMS.register("chisel",
            () -> new ChiselItem(new Item.Properties().durability(32)));

    public static final RegistryObject<Item> KOHLRABI = ITEMS.register("kohlrabi",
            () -> new Item(new Item.Properties().food(ModFoodProperties.KOHLRABI)) {
                @Override
                public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
                    pTooltipComponents.add(Component.translatable("tooltip.firstmod.kohlrabi.tooltip"));
                    super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
                }
            });

    public static final RegistryObject<Item> AURORA_ASHES = ITEMS.register("aurora_ashes",
            () -> new FuelItem(new Item.Properties(), 1200));

    public static final RegistryObject<Item> ALEXANDRITE_SWORD = ITEMS.register("alexandrite_sword",
            () -> new SwordItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(SwordItem.m_322253_(ModToolTiers.ALEXANDRITE, 3, -2.4f))));
    public static final RegistryObject<Item> ALEXANDRITE_PICKAXE = ITEMS.register("alexandrite_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(PickaxeItem.m_320415_(ModToolTiers.ALEXANDRITE, 1, 2.8f))));
    public static final RegistryObject<Item> ALEXANDRITE_AXE = ITEMS.register("alexandrite_axe",
            () -> new AxeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(AxeItem.m_320415_(ModToolTiers.ALEXANDRITE, 6, -3.2f))));
    public static final RegistryObject<Item> ALEXANDRITE_SHOVEL = ITEMS.register("alexandrite_shovel",
            () -> new ShovelItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(ShovelItem.m_320415_(ModToolTiers.ALEXANDRITE, 1.5f, -3.0f))));
    public static final RegistryObject<Item> ALEXANDRITE_HOE = ITEMS.register("alexandrite_hoe",
            () -> new HoeItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(HoeItem.m_320415_(ModToolTiers.ALEXANDRITE, 0, -3f))));
    public static final RegistryObject<Item> ALEXANDRITE_HAMMER = ITEMS.register("alexandrite_hammer",
            () -> new HammerItem(ModToolTiers.ALEXANDRITE, new Item.Properties()
                    .attributes(PickaxeItem.m_320415_(ModToolTiers.ALEXANDRITE, 7, -3.5f))));

    // The .m_321370 is .getDurability but my parchment version doesn't have it
    public static final RegistryObject<Item> ALEXANDRITE_HELMET = ITEMS.register("alexandrite_helmet",
            () -> new ModArmorItem(ModArmorMaterials.ALEXANDRITE_AROMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.m_321370_(18))));
    public static final RegistryObject<Item> ALEXANDRITE_BOOTS = ITEMS.register("alexandrite_boots",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_AROMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.m_321370_(18))));
    public static final RegistryObject<Item> ALEXANDRITE_CHESTPLATE = ITEMS.register("alexandrite_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_AROMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.m_321370_(18))));
    public static final RegistryObject<Item> ALEXANDRITE_LEGGINGS = ITEMS.register("alexandrite_leggings",
            () -> new ArmorItem(ModArmorMaterials.ALEXANDRITE_AROMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.m_321370_(18))));

    public static final RegistryObject<Item> ALEXANDRITE_HORSE_AROMOR = ITEMS.register("alexandrite_horse_armor",
            () -> new AnimalArmorItem(ModArmorMaterials.ALEXANDRITE_AROMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN,
                    false, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> VORRIK_BOW = ITEMS.register("vorrik_bow",
            () -> new BowItem(new Item.Properties().durability(500)));

    // Method to register the items
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
