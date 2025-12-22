package com.random.randomness;

import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModScreenHandlers {
    public static ScreenHandlerType<BluerScreenHandler> BLUER_SCREEN_HANDLER;

    public static void registerAll() {
        BLUER_SCREEN_HANDLER = Registry.register(Registry.SCREEN_HANDLER, new Identifier(Randomness.MOD_ID, "bluer"), new ScreenHandlerType<>((syncId, playerInventory) -> new BluerScreenHandler(syncId, playerInventory, new net.minecraft.inventory.SimpleInventory(3), net.minecraft.screen.ScreenHandlerContext.EMPTY)));
    }
}
