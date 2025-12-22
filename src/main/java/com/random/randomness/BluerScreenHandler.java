package com.random.randomness;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.*;
import net.minecraft.screen.slot.Slot;

public class BluerScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public BluerScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, ScreenHandlerContext ctx) {
        super(ModScreenHandlers.BLUER_SCREEN_HANDLER, syncId);
        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        // Inputs: slot 0 and 1
        this.addSlot(new Slot(inventory, 0, 44, 17));
        this.addSlot(new Slot(inventory, 1, 62, 17));

        // Output: slot 2 (cannot place items)
        this.addSlot(new Slot(inventory, 2, 116, 35) {
            @Override
            public boolean canInsert(ItemStack stack) { return false; }
        });

        // Player inventory
        int m;
        int l;

        for (m = 0; m < 3; ++m) {
            for (l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }

        for (m = 0; m < 9; ++m) {
            this.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack stack = slot.getStack();
            itemStack = stack.copy();

            if (index < this.inventory.size()) {
                if (!this.insertItem(stack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(stack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (stack.isEmpty()) slot.setStack(ItemStack.EMPTY);
            else slot.markDirty();
        }

        return itemStack;
    }

    @Override
    public void close(PlayerEntity player) {
        super.close(player);
        this.inventory.onClose(player);
    }
}
