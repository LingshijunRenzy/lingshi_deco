package com.lingshideco.register;

import java.util.ArrayList;
import java.util.List;

public class LingshiRegistryData {
    public List<Block> blocks = new ArrayList<>();
    public List<Item> items = new ArrayList<>();
    public List<ItemGroup> itemGroups = new ArrayList<>();

    public static class ItemGroup {
        public String name;
        public String icon;

        public ItemGroup(String name, String icon) {
            this.name = name;
            this.icon = icon;
        }
    }

    public static class Block implements Cloneable{
        public String name;
        public String itemGroup;
        public String vanillaParent;
        public String blockType;

        public Block name(String name) {
            this.name = name;
            return this;
        }

        public Block itemGroup(String itemGroup) {
            this.itemGroup = itemGroup;
            return this;
        }

        public Block vanillaParent(String vanillaParent) {
            this.vanillaParent = vanillaParent;
            return this;
        }

        public Block blockType(String blockType) {
            this.blockType = blockType;
            return this;
        }
    }

    public static class Item{
        public String name;
        public String itemGroup;
        public String type; //Item, BlockItem

        public Item(String name, String itemGroup, String type) {
            this.name = name;
            this.itemGroup = itemGroup;
            this.type = type;
        }
    }
}
