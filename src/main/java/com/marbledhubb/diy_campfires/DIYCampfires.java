package com.marbledhubb.diy_campfires;

import com.marbledhubb.diy_campfires.init.ModBlocks;
import com.marbledhubb.diy_campfires.init.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

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

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
    }

    @SubscribeEvent
    public void onCreativeModeTab(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS)
        {
            ItemStack item = ModBlocks.FIREWOOD.get().asItem().getDefaultInstance();
            event.getEntries().putBefore(Items.BROWN_MUSHROOM.getDefaultInstance(),item,event.getEntries().get(Items.BROWN_MUSHROOM.getDefaultInstance()));
        }
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
