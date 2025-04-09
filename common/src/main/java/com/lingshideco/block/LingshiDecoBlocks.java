package com.lingshideco.block;

import com.lingshideco.register.LingshiRegistryData;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class LingshiDecoBlocks {
    public static final Map<String, LingshiRegistryData.Block> ModBlocks = new HashMap<>();

    public static void initialize() {
        ModBlocks.put("patterned_brick_1", new LingshiRegistryData.Block()
                .name("patterned_brick_1")
                .blockType("base")
                .itemGroup("patterned_brick_1")
                .vanillaParent("minecraft:bricks"));
        ModBlocks.put("patterned_brick_2", new LingshiRegistryData.Block()
                .name("patterned_brick_2")
                .blockType("base")
                .itemGroup("patterned_brick_2")
                .vanillaParent("minecraft:bricks"));
        ModBlocks.put("patterned_brick_3", new LingshiRegistryData.Block()
                .name("patterned_brick_3")
                .blockType("base")
                .itemGroup("patterned_brick_3")
                .vanillaParent("minecraft:bricks"));
        ModBlocks.put("patterned_brick_4", new LingshiRegistryData.Block()
                .name("patterned_brick_4")
                .blockType("base")
                .itemGroup("patterned_brick_4")
                .vanillaParent("minecraft:bricks"));
    }
}