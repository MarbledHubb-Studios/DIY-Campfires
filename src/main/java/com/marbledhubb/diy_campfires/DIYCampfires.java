package com.marbledhubb.diy_campfires;

import com.marbledhubb.diy_campfires.init.BeautifulCampfiresBlocks;
import com.marbledhubb.diy_campfires.init.BeautifulCampfiresItems;
import com.marbledhubb.diy_campfires.init.ModBlocks;
import com.marbledhubb.diy_campfires.init.ModItems;
import com.marbledhubb.diy_campfires.init.item.FirewoodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.DeferredItem;

@Mod(DIYCampfires.MODID)
public class DIYCampfires
{
    public static final String MODID = "diy_campfires";

    //well, you were right. mmm wood

    public DIYCampfires(IEventBus modEventBus, ModContainer modContainer)
    {
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::creativeModeTabContents);

        /* Not needed, Beautiful Campfires does not have a 26.1.2 version
        boolean isBeautifulCampfiresLoaded =  ModList.get().isLoaded("beautifulcampfires");

        if (isBeautifulCampfiresLoaded) BeautifulCampfiresItems.register();
        */
        ModItems.register(modEventBus);

        /*
        if (isBeautifulCampfiresLoaded) BeautifulCampfiresBlocks.register();
        */
        ModBlocks.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    public void creativeModeTabContents(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            addCreativeModeTabEntry(event, ModItems.FIREWOOD);

            /*
            if (!ModList.get().isLoaded("beautifulcampfires")) return;

            addCreativeModeTabEntry(event, BeautifulCampfiresItems.ACACIA_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.BAMBOO_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.BIRCH_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.CHERRY_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.CRIMSON_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.DARK_OAK_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.JUNGLE_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.MANGROVE_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.SPRUCE_FIREWOOD);
            addCreativeModeTabEntry(event, BeautifulCampfiresItems.WARPED_FIREWOOD);
             */
        }
    }

    private void addCreativeModeTabEntry(BuildCreativeModeTabContentsEvent event, DeferredItem<FirewoodItem> item)
    {
        ItemStack itemStack = item.asItem().getDefaultInstance();
        event.insertBefore(Items.BROWN_MUSHROOM.getDefaultInstance(), itemStack,CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @EventBusSubscriber(modid = MODID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}