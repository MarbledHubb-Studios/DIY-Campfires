package com.marbledhubb.diy_campfires.init.items;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class FirewoodItem extends Item {
    private final Block block;

    public FirewoodItem(Block block, Item.Properties properties) {
        super(properties);
        this.block = block;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 400;
    }
}
