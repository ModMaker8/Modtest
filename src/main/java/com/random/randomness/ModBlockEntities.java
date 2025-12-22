package com.random.randomness;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<BluerBlockEntity> BLUER_BLOCK_ENTITY;

    public static void registerAll() {
        BLUER_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(Randomness.MOD_ID, "bluer"), BlockEntityType.Builder.create(BluerBlockEntity::new, ModBlocks.BLUER_BLOCK).build(null));
    }
}
