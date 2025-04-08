package com.lingshideco.block;

import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;

public class LingshiDecoBlocks {
    public static final Map<String, Block> Blocks = new HashMap<>();

    public static void initialize(){
        // Initialize all blocks here
        // Example: Blocks.put("example_block", new ExampleBlock());
        //Blocks.put("patterned_brick_1", new AbstractLingshiDecoBlock(Block.Properties.copy(Block.byName("stone_bricks"))));
    }
}
