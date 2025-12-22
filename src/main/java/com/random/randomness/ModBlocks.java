package com.random.randomness;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final ItemGroup RANDOMNESS_GROUP = FabricItemGroupBuilder.build(
        new Identifier(Randomness.MOD_ID, "randomness"),
        () -> new ItemStack(net.minecraft.item.Items.STONE)
    );

    public static final Block PIKITE_BLOCK = new RandomBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE).strength(1.5f, 6.0f).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block PIKITE_ORE = new PikiteOreBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE).strength(3.0f, 9.0f).requiresTool().sounds(BlockSoundGroup.STONE), UniformIntProvider.create(0,0));
    
    public static final Block BLUEITE_BLOCK = new RandomBlock(FabricBlockSettings.of(net.minecraft.block.Material.STONE).strength(1.5f, 6.0f).requiresTool().sounds(BlockSoundGroup.STONE));
    public static final Block BLUER_BLOCK = new BluerBlock(FabricBlockSettings.of(net.minecraft.block.Material.WOOD).strength(2.0f).sounds(BlockSoundGroup.WOOD));

    public static void registerAll() {
        Registry.register(Registry.BLOCK, new Identifier(Randomness.MOD_ID, "pikite"), PIKITE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(Randomness.MOD_ID, "pikite_ore"), PIKITE_ORE);

        Registry.register(Registry.ITEM, new Identifier(Randomness.MOD_ID, "pikite"), ModItems.PIKITE_BLOCK_ITEM);
        Registry.register(Registry.ITEM, new Identifier(Randomness.MOD_ID, "pikite_ore"), ModItems.PIKITE_ORE_ITEM);
        Registry.register(Registry.BLOCK, new Identifier(Randomness.MOD_ID, "blueite"), BLUEITE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Randomness.MOD_ID, "blueite"), ModItems.BLUEITE_BLOCK_ITEM);
        Registry.register(Registry.BLOCK, new Identifier(Randomness.MOD_ID, "bluer"), BLUER_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(Randomness.MOD_ID, "bluer"), ModItems.BLUER_BLOCK_ITEM);
    }
    // Worldgen not registered in Java to avoid mapping issues.
    // To add ore generation, add a data pack under data/randomness/worldgen or implement generation code tailored to your mappings.
}
