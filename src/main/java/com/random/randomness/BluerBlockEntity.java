package com.random.randomness;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.nbt.NbtElement;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.TranslatableText;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.BlockState;

public class BluerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    private final SimpleInventory inventory = new SimpleInventory(3); // 2 inputs + 1 output

    public BluerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BLUER_BLOCK_ENTITY, pos, state);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public TranslatableText getDisplayName() {
        return new TranslatableText("container.randomness.bluer");
    }

    @Override
    public net.minecraft.screen.ScreenHandler createMenu(int syncId, net.minecraft.entity.player.PlayerInventory inv, PlayerEntity player) {
        return new BluerScreenHandler(syncId, inv, this.inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        if (tag.contains("Items", NbtElement.LIST_TYPE)) {
            NbtList list = tag.getList("Items", NbtElement.COMPOUND_TYPE);
            for (int i = 0; i < list.size(); i++) {
                NbtCompound itemTag = list.getCompound(i);
                int slot = itemTag.getByte("Slot");
                if (slot >= 0 && slot < this.inventory.size()) {
                    this.inventory.setStack(slot, ItemStack.fromNbt(itemTag));
                }
            }
        }
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        NbtList list = new NbtList();
        for (int i = 0; i < this.inventory.size(); i++) {
            ItemStack stack = this.inventory.getStack(i);
            if (!stack.isEmpty()) {
                NbtCompound itemTag = stack.writeNbt(new NbtCompound());
                itemTag.putByte("Slot", (byte) i);
                list.add(itemTag);
            }
        }
        tag.put("Items", list);
    }
}
