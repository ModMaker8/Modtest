package com.random.randomness.mixin;

import com.random.randomness.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class ItemMiningSpeedMixin {
    @Inject(at = @At("HEAD"), method = "getMiningSpeedMultiplier(Lnet/minecraft/item/ItemStack;Lnet/minecraft/block/BlockState;)F", cancellable = true)
    private void onGetMiningSpeedMultiplier(ItemStack stack, BlockState state, CallbackInfoReturnable<Float> cir) {
        if (state == null || stack == null) return;

        if (state.getBlock() == ModBlocks.PIKITE_ORE) {
            if (stack.getItem() == Items.NETHERITE_PICKAXE) cir.setReturnValue(4.0f);
            else if (stack.getItem() == Items.DIAMOND_PICKAXE) cir.setReturnValue(3.0f);
            else if (stack.getItem() == Items.IRON_PICKAXE) cir.setReturnValue(1.5f);
            else cir.setReturnValue(0.2f);
        } else if (state.getBlock() == ModBlocks.PIKITE_BLOCK || state.getBlock() == ModBlocks.BLUEITE_BLOCK) {
            if (stack.getItem() == Items.NETHERITE_PICKAXE) cir.setReturnValue(9.0f);
            else if (stack.getItem() == Items.DIAMOND_PICKAXE) cir.setReturnValue(8.0f);
            else if (stack.getItem() == Items.IRON_PICKAXE) cir.setReturnValue(6.0f);
            else if (stack.getItem() == Items.STONE_PICKAXE) cir.setReturnValue(4.0f);
            else if (stack.getItem() == Items.WOODEN_PICKAXE) cir.setReturnValue(2.0f);
            else cir.setReturnValue(1.0f);
        }
    }
}
