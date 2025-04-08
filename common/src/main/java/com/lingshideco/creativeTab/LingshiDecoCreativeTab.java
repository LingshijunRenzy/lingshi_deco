package com.lingshideco.creativeTab;

import com.lingshideco.register.LingshiDecoRegistries;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import static com.lingshideco.LingshiDeco.MOD_ID;

public class LingshiDecoCreativeTab {
    public static final Map<String, RegistrySupplier<CreativeModeTab>> ModTabs = new HashMap<>();
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(MOD_ID, Registries.CREATIVE_MODE_TAB);

    //main tab
    public static final RegistrySupplier<CreativeModeTab> MOD_MAIN_TAB = create("main", () -> LingshiDecoRegistries.ITEM_SUPPLIERS.get(new ResourceLocation(MOD_ID, "main_tab_icon")).get());

    public static RegistrySupplier<CreativeModeTab> create(String name, Supplier<Item> item){
        if(ModTabs.containsKey(name)){
            return ModTabs.get(name);
        }else{
            RegistrySupplier<CreativeModeTab> tab = CREATIVE_MODE_TABS.register(new ResourceLocation(MOD_ID, name), () -> CreativeTabRegistry.create(Component.translatable("itemGroup.lingshideco." + name), () -> new ItemStack(item.get())));
            return tab;
        }
    }

    public static void registerCreativeTabs(String name, String icon) {
        create(name, () -> {
            if (icon.contains(":")) return BuiltInRegistries.ITEM.get(ResourceLocation.tryParse(icon));
            else {
                Supplier<Item> item = LingshiDecoRegistries.ITEM_SUPPLIERS.get(ResourceLocation.tryParse(icon));
                return item != null ? item.get() : Items.APPLE;
            }
        });
    }

    public static RegistrySupplier<CreativeModeTab> getTab(String name) {
        return ModTabs.getOrDefault(name, MOD_MAIN_TAB);
    }
}