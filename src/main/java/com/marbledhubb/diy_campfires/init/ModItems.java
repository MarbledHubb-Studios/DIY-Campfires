package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import com.marbledhubb.diy_campfires.init.item.FirewoodItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(DIYCampfires.MODID);

    public static final DeferredRegister<Item> FIREWOOD = ITEMS.registerItem("firewood", () -> new FirewoodItem(ModBlocks.FIREWOOD, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
