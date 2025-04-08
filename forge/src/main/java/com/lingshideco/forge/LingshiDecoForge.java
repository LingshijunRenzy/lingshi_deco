package com.lingshideco.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import com.lingshideco.LingshiDeco;

@Mod(LingshiDeco.MOD_ID)
public final class LingshiDecoForge {
    public LingshiDecoForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(LingshiDeco.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        LingshiDeco.init();
    }
}
