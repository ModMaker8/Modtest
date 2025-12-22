package com.random.randomness;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static final Item PIKITE_BLOCK_ITEM = new BlockItem(ModBlocks.PIKITE_BLOCK, new Item.Settings().group(ModBlocks.RANDOMNESS_GROUP));
    public static final Item PIKITE_ORE_ITEM = new BlockItem(ModBlocks.PIKITE_ORE, new Item.Settings().group(ModBlocks.RANDOMNESS_GROUP));
    public static final Item BLUEITE_BLOCK_ITEM = new BlockItem(ModBlocks.BLUEITE_BLOCK, new Item.Settings().group(ModBlocks.RANDOMNESS_GROUP));
    public static final Item BLUER_BLOCK_ITEM = new BlockItem(ModBlocks.BLUER_BLOCK, new Item.Settings().group(ModBlocks.RANDOMNESS_GROUP));

    public static void registerAll() {
        // Block item registration is performed in ModBlocks.registerAll to keep ordering consistent.
    }
}
