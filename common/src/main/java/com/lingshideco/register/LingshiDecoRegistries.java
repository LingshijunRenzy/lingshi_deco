package com.lingshideco.register;

import com.google.common.base.Suppliers;
import com.lingshideco.block.BlockFactory;
import com.lingshideco.creativeTab.LingshiDecoCreativeTab;
import dev.architectury.registry.registries.Registrar;
import dev.architectury.registry.registries.RegistrarManager;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.lingshideco.LingshiDeco.MOD_ID;
import static com.lingshideco.block.LingshiDecoBlocks.ModBlocks;

public class LingshiDecoRegistries {
    public static final Supplier<RegistrarManager> MANAGER_SUPPLIER = Suppliers
            .memoize(() -> RegistrarManager.get(MOD_ID));

    public static final Registrar<Item> ITEMS = MANAGER_SUPPLIER.get().get(Registries.ITEM);
    public static final Registrar<Block> BLOCKS = MANAGER_SUPPLIER.get().get(Registries.BLOCK);

    public static final Map<String, RegistrySupplier<Block>> BLOCK_SUPPLIERS = new HashMap<>();
    public static final Map<String, RegistrySupplier<Item>> ITEM_SUPPLIERS = new HashMap<>();

    public static void register() {
        LingshiDecoCreativeTab.CREATIVE_MODE_TABS.register();

        registerBlocks();
    }

    private static void registerBlocks() {
        // 注册所有方块，但不立即获取实例
        for(LingshiRegistryData.Block block : ModBlocks.values()){
            // 注册方块，使用注册供应商
            RegistrySupplier<Block> blockSupplier = BLOCKS.register(new ResourceLocation(MOD_ID, block.name), () -> BlockFactory.createBlock(block));
            BLOCK_SUPPLIERS.put(block.name, blockSupplier);

            // 注册方块物品，使用注册供应商
            RegistrySupplier<Item> itemSupplier = ITEMS.register(new ResourceLocation(MOD_ID, block.name), () -> new BlockItem(blockSupplier.get(), new Item.Properties().arch$tab(LingshiDecoCreativeTab.getTab(block.itemGroup))));
            ITEM_SUPPLIERS.put(block.name, itemSupplier);
        }
    }
}
