package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import com.marbledhubb.diy_campfires.init.block.BeautifulCampfiresOakFirewoodBlock;
import com.marbledhubb.diy_campfires.init.block.FirewoodBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlocks {
    public static DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(DIYCampfires.MODID);

    public static final DeferredBlock<FirewoodBlock> FIREWOOD = registerBlock("firewood", getOakFirewoodSupplier());

    private static Supplier<FirewoodBlock> getOakFirewoodSupplier() {
        if (ModList.get().isLoaded("beautifulcampfires"))
            return () -> new BeautifulCampfiresOakFirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).noOcclusion().ignitedByLava().strength(0.5F),
                    Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE);

        return () -> new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).noOcclusion().ignitedByLava().strength(0.5F),
                        Blocks.CAMPFIRE, Blocks.SOUL_CAMPFIRE);
    }

    public static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }



    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}