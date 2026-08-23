package com.marbledhubb.diy_campfires.init.block;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class BeautifulCampfiresOakFirewoodBlock extends FirewoodBlock {
    @Nullable
    private String descriptionId;

    public BeautifulCampfiresOakFirewoodBlock(Properties properties, Block campfireBlock, Block soulCampfireBlock) {
        super(properties, campfireBlock, soulCampfireBlock);
    }

    @Override
    public @NotNull MutableComponent getName() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("block", Identifier.fromNamespaceAndPath(DIYCampfires.MODID, "oak_firewood"));
        }

        return Component.literal(descriptionId);
    }
}