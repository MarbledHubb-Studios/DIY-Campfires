package com.marbledhubb.diy_campfires.init.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FirewoodItem extends BlockItem {
    public FirewoodItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType, FuelValues fuelValues) {
        return 300;
    }

}