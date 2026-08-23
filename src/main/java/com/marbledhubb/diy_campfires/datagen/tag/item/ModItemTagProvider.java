package com.marbledhubb.diy_campfires.datagen.tag.item;

import com.marbledhubb.diy_campfires.DIYCampfires;
import com.marbledhubb.diy_campfires.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends ItemTagsProvider {

    public ModItemTagProvider(
            PackOutput output,
            CompletableFuture<HolderLookup.Provider> lookupProvider
    ) {
        super(output, lookupProvider, DIYCampfires.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.CAMPFIRE_FINISHING_MATERIAL)
                .add(Items.COAL)
                .add(Items.CHARCOAL);

        tag(ModTags.Items.SOUL_CAMPFIRE_FINISHING_MATERIAL)
                .add(Items.SOUL_SAND)
                .add(Items.SOUL_SOIL);
    }
}