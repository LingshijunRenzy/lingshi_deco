package com.lingshideco.datagen;

import com.lingshideco.LingshiDeco;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = LingshiDeco.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LingshiDecoDataGenerator {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper efh = event.getExistingFileHelper();
        generator.addProvider(event.includeClient(), new LingshiDecoBlockStateProvider(generator.getPackOutput(), LingshiDeco.MOD_ID, efh));
    }
}
