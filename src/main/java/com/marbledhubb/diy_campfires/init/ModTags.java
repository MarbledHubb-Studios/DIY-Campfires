package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class ModTags {

    public static class Items {

        public static final TagKey<Item> CAMPFIRE_FINISHING_MATERIAL =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DIYCampfires.MODID, "campfire_finishing_material"));

        public static final TagKey<Item> SOUL_CAMPFIRE_FINISHING_MATERIAL =
                TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(DIYCampfires.MODID, "soul_campfire_finishing_material"));

    }

}