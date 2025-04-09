package com.lingshideco.datagen;

import com.lingshideco.block.BlockFactory;
import com.lingshideco.block.LingshiDecoBlocks;
import com.lingshideco.register.LingshiDecoRegistries;
import com.lingshideco.register.LingshiRegistryData;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

import static com.lingshideco.LingshiDeco.MOD_ID;

public class LingshiDecoBlockStateProvider extends BlockStateProvider {
    public LingshiDecoBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(LingshiRegistryData.Block rawBlock : LingshiDecoBlocks.ModBlocks.values()){
            Block block = BlockFactory.createBlock(rawBlock);
            switch(rawBlock.blockType){
                case "base" -> {
                    simpleBlock(block);
                }
            }
        }
    }
}
