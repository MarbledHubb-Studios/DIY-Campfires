package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> CAMPFIRE_IGNITER =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DIYCampfires.MODID, "campfire_igniter"));

        public static final TagKey<Item> SOUL_CAMPFIRE_IGNITER =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DIYCampfires.MODID, "soul_campfire_igniter"));

    }


}