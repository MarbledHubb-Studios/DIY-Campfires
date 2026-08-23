package com.marbledhubb.diy_campfires.datagen;

import com.marbledhubb.diy_campfires.DIYCampfires;
import com.marbledhubb.diy_campfires.datagen.tag.block.ModBlockTagProvider;
import com.marbledhubb.diy_campfires.datagen.tag.item.ModItemTagProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@EventBusSubscriber(modid = DIYCampfires.MODID)
public class ModDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Server event) {
        event.createProvider(
                ModBlockTagProvider::new
        );

        event.createProvider(
                ModItemTagProvider::new
        );
    }
}