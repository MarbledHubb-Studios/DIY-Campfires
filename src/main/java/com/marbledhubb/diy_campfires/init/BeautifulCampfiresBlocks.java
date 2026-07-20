package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.init.block.FirewoodBlock;
import fr.shoqapik.beautifulcampfires.BeautifulCampfires;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;

public class BeautifulCampfiresBlocks {
    public static final DeferredBlock<FirewoodBlock> ACACIA_FIREWOOD = ModBlocks.registerBlock("acacia_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "acacia_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "acacia_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> BAMBOO_FIREWOOD = ModBlocks.registerBlock("bamboo_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_WOOD).mapColor(MapColor.PLANT).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "bamboo_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "bamboo_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> BIRCH_FIREWOOD = ModBlocks.registerBlock("birch_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "birch_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "birch_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> CHERRY_FIREWOOD = ModBlocks.registerBlock("cherry_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "cherry_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "cherry_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> CRIMSON_FIREWOOD = ModBlocks.registerBlock("crimson_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRIMSON_HYPHAE).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "crimson_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "crimson_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> DARK_OAK_FIREWOOD = ModBlocks.registerBlock("dark_oak_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "dark_oak_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "dark_oak_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> JUNGLE_FIREWOOD = ModBlocks.registerBlock("jungle_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "jungle_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "jungle_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> MANGROVE_FIREWOOD = ModBlocks.registerBlock("mangrove_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "mangrove_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "mangrove_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> SPRUCE_FIREWOOD = ModBlocks.registerBlock("spruce_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_WOOD).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "spruce_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "spruce_soul_campfire"))));
    public static final DeferredBlock<FirewoodBlock> WARPED_FIREWOOD = ModBlocks.registerBlock("warped_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_HYPHAE).noOcclusion().strength(0.5F),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "warped_campfire")),
                    BuiltInRegistries.BLOCK.get(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "warped_soul_campfire"))));

    public static void register() {
    }
}
