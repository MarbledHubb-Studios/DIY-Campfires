package com.marbledhubb.diy_campfires.init;

import com.marbledhubb.diy_campfires.init.blocks.FirewoodBlock;
import fr.shoqapik.beautifulcampfires.BeautifulCampfires;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BeautifulCampfiresBlocks {
    public static final RegistryObject<Block> ACACIA_FIREWOOD = ModBlocks.registerBlock("acacia_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.ACACIA_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "acacia_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "acacia_soul_campfire"))));
    public static final RegistryObject<Block> BAMBOO_FIREWOOD = ModBlocks.registerBlock("bamboo_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).mapColor(MapColor.PLANT).sound(SoundType.BAMBOO_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "bamboo_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "bamboo_soul_campfire"))));
    public static final RegistryObject<Block> BIRCH_FIREWOOD = ModBlocks.registerBlock("birch_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.BIRCH_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "birch_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "birch_soul_campfire"))));
    public static final RegistryObject<Block> CHERRY_FIREWOOD = ModBlocks.registerBlock("cherry_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.CHERRY_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "cherry_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "cherry_soul_campfire"))));
    public static final RegistryObject<Block> CRIMSON_FIREWOOD = ModBlocks.registerBlock("crimson_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.CRIMSON_HYPHAE).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "crimson_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "crimson_soul_campfire"))));
    public static final RegistryObject<Block> DARK_OAK_FIREWOOD = ModBlocks.registerBlock("dark_oak_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "dark_oak_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "dark_oak_soul_campfire"))));
    public static final RegistryObject<Block> JUNGLE_FIREWOOD = ModBlocks.registerBlock("jungle_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.JUNGLE_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "jungle_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "jungle_soul_campfire"))));
    public static final RegistryObject<Block> MANGROVE_FIREWOOD = ModBlocks.registerBlock("mangrove_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.MANGROVE_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "mangrove_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "mangrove_soul_campfire"))));
    public static final RegistryObject<Block> SPRUCE_FIREWOOD = ModBlocks.registerBlock("spruce_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_WOOD).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "spruce_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "spruce_soul_campfire"))));
    public static final RegistryObject<Block> WARPED_FIREWOOD = ModBlocks.registerBlock("warped_firewood", () ->
            new FirewoodBlock(BlockBehaviour.Properties.copy(Blocks.WARPED_HYPHAE).noOcclusion().strength(0.5F),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "warped_campfire")),
                    ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath(BeautifulCampfires.MODID, "warped_soul_campfire"))));


    public static void register() {
    }
}
