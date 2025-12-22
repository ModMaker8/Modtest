package com.random.randomness;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static BlockEntityType<BluerBlockEntity> BLUER_BLOCK_ENTITY = null;

    public static void registerAll() {
        // Block entities are not registered; Bluer uses a transient inventory in the GUI.
    }
}
