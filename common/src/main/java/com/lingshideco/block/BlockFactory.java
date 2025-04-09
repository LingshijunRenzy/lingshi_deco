package com.lingshideco.block;

import com.lingshideco.register.LingshiRegistryData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class BlockFactory {
    public static Block createBlock(LingshiRegistryData.Block blockData) {
        BlockBehaviour.Properties properties = getBlockProperties(blockData);
        return new AbstractLingshiDecoBlock(properties);
    }

    public static BlockBehaviour.Properties getBlockProperties(LingshiRegistryData.Block blockData) {
        BlockBehaviour.Properties properties = null;

        // get the vanilla parent block, extends the properties
        String vanillaParent = blockData.vanillaParent;

        // 去除冒号和冒号前面的部分,只要id
        if(vanillaParent.contains(":")) {
            vanillaParent = vanillaParent.split(":")[1];
        }
        // get the block class
        // 转为全大写
        String blockClassName = vanillaParent.toUpperCase();

        // get block properties
        try{
            Block vanillaBlock = (Block) Blocks.class.getField(blockClassName).get(null);
            if(vanillaBlock != null) {
                properties = BlockBehaviour.Properties.copy(vanillaBlock);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        return properties;
    }
}
