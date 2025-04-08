package com.lingshideco;

import com.lingshideco.block.LingshiDecoBlocks;
import com.lingshideco.register.LingshiDecoRegistries;

public final class LingshiDeco {
    public static final String MOD_ID = "lingshi_deco";

    public static void init() {
        // Write common init code here.
        LingshiDecoBlocks.initialize();

        LingshiDecoRegistries.register();
    }
}
