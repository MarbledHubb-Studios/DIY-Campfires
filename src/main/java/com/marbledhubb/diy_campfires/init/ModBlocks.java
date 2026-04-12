package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.DIYCampfires;
import com.marbledhubb.diy_campfires.init.block.FirewoodBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;


public class ModBlocks {
    public static DeferredRegister<Block> BLOCKS =
            DeferredRegister.createBlocks(DIYCampfires.MODID);
    //brok en bloc :(
//    public static final DeferredRegister<Block> FIREWOOD = registerBlock("firewood", () ->
//            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).noOcclusion().ignitedByLava().strength(0.5F)));


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
