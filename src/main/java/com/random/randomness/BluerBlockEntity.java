package com.random.randomness;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.text.Text;

public class BluerBlockEntity extends BlockEntity implements NamedScreenHandlerFactory {
    private final SimpleInventory inventory = new SimpleInventory(3); // 2 inputs + 1 output

    public BluerBlockEntity() {
        super(ModBlockEntities.BLUER_BLOCK_ENTITY);
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.randomness.bluer");
    }

    @Override
    public net.minecraft.screen.ScreenHandler createMenu(int syncId, net.minecraft.entity.player.PlayerInventory inv, PlayerEntity player) {
        return new BluerScreenHandler(syncId, inv, this.inventory, ScreenHandlerContext.create(world, pos));
    }

    @Override
    public void readNbt(NbtCompound tag) {
        super.readNbt(tag);
        this.inventory.readNbt(tag);
    }

    @Override
    public void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        this.inventory.writeNbt(tag);
    }
}
