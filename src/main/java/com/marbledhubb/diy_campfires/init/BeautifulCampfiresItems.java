package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.init.items.FirewoodItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class BeautifulCampfiresItems {
    public static final RegistryObject<Item> ACACIA_FIREWOOD = ModItems.ITEMS.register("acacia_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.ACACIA_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BAMBOO_FIREWOOD = ModItems.ITEMS.register("bamboo_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.BAMBOO_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> BIRCH_FIREWOOD = ModItems.ITEMS.register("birch_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.BIRCH_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_FIREWOOD = ModItems.ITEMS.register("cherry_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.CHERRY_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> CRIMSON_FIREWOOD = ModItems.ITEMS.register("crimson_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.CRIMSON_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> DARK_OAK_FIREWOOD = ModItems.ITEMS.register("dark_oak_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.DARK_OAK_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> JUNGLE_FIREWOOD = ModItems.ITEMS.register("jungle_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.JUNGLE_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> MANGROVE_FIREWOOD = ModItems.ITEMS.register("mangrove_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.MANGROVE_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRUCE_FIREWOOD = ModItems.ITEMS.register("spruce_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.SPRUCE_FIREWOOD.get(), new Item.Properties()));
    public static final RegistryObject<Item> WARPED_FIREWOOD = ModItems.ITEMS.register("warped_firewood", () -> new FirewoodItem(BeautifulCampfiresBlocks.WARPED_FIREWOOD.get(), new Item.Properties()));

    public static void register() {
    }
}
