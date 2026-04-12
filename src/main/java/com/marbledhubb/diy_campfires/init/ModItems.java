package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister<Item> ITEMS =
            DeferredRegister.createItems(DIYCampfires.MODID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
