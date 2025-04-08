package com.lingshideco.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LingshiDecoBlocks {
    public static final Map<String, Supplier<Block>> ModBlocks = new HashMap<>();

    public static void initialize(){
        // Initialize all blocks here
        // Example: Blocks.put("example_block", new ExampleBlock());
        ModBlocks.put("patterned_brick_1", () -> new AbstractLingshiDecoBlock(BlockBehaviour.Properties.copy(Blocks.STONE)));
    }
}
