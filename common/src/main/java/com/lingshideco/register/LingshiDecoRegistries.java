package com.lingshideco.register;

import com.google.common.base.Suppliers;
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
        registerBlocks();
        registerBlockItems();
    }

    private static void registerBlocks() {
        // 注册所有方块，但不立即获取实例
        for (Map.Entry<String, Supplier<Block>> entry : ModBlocks.entrySet()) {
            String key = entry.getKey();
            Supplier<Block> blockSupplier = entry.getValue();

            // 保存注册供应商，不要调用.get()
            RegistrySupplier<Block> registrySupplier = BLOCKS.register(
                    new ResourceLocation(MOD_ID, key),
                    blockSupplier);

            BLOCK_SUPPLIERS.put(key, registrySupplier);
            System.out.println("注册方块: " + key);
        }
    }

    private static void registerBlockItems() {
        // 注册方块物品，使用注册供应商
        for (String key : BLOCK_SUPPLIERS.keySet()) {
            RegistrySupplier<Block> blockSupplier = BLOCK_SUPPLIERS.get(key);

            RegistrySupplier<Item> itemSupplier = ITEMS.register(
                    new ResourceLocation(MOD_ID, key),
                    () -> new BlockItem(blockSupplier.get(), new Item.Properties()));

            ITEM_SUPPLIERS.put(key, itemSupplier);

            System.out.println("注册方块物品: " + key);
        }
    }
}
