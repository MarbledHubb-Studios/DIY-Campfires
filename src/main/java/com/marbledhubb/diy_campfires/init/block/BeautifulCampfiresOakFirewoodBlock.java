package com.marbledhubb.diy_campfires.init.block;

import com.marbledhubb.diy_campfires.DIYCampfires;
import net.minecraft.Util;
import net.minecraft.resources.ResourceLocation;
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
    public @NotNull String getDescriptionId() {
        if (this.descriptionId == null) {
            this.descriptionId = Util.makeDescriptionId("block", ResourceLocation.fromNamespaceAndPath(DIYCampfires.MODID, "oak_firewood"));
        }

        return this.descriptionId;
    }
}
