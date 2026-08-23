package com.marbledhubb.diy_campfires.datagen.tag.block;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {

    public ModBlockTagProvider(PackOutput output,
                               CompletableFuture<HolderLookup.Provider> lookupProvider) {

        super(output, lookupProvider, DIYCampfires.MODID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {}
}