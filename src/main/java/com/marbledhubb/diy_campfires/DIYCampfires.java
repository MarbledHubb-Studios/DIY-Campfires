package com.marbledhubb.diy_campfires;

import com.marbledhubb.diy_campfires.init.BeautifulCampfiresBlocks;
import com.marbledhubb.diy_campfires.init.BeautifulCampfiresItems;
import com.marbledhubb.diy_campfires.init.ModBlocks;
import com.marbledhubb.diy_campfires.init.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;

@Mod(DIYCampfires.MODID)
public class DIYCampfires
{
    public static final String MODID = "diy_campfires";

    //mmm wood

    public DIYCampfires(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::onCreativeModeTab);

        boolean isBeautifulCampfiresLoaded =  ModList.get().isLoaded("beautifulcampfires");

        if (isBeautifulCampfiresLoaded) BeautifulCampfiresItems.register();
        ModItems.register(modEventBus);
        if (isBeautifulCampfiresLoaded) BeautifulCampfiresBlocks.register();
        ModBlocks.register(modEventBus);
    }

    @SubscribeEvent
    public void onCreativeModeTab(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            addCreativeModeTabEntry(event, ModItems.FIREWOOD);

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
        }
    }

    private void addCreativeModeTabEntry(BuildCreativeModeTabContentsEvent event, RegistryObject<Item> item)
    {
        ItemStack itemStack = item.get().getDefaultInstance();
        event.getEntries().putBefore(Items.BROWN_MUSHROOM.getDefaultInstance(),itemStack,event.getEntries().get(Items.BROWN_MUSHROOM.getDefaultInstance()));
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
