package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Item.class)
abstract class ItemMixin implements ItemConvertible {
    @ModifyExpressionValue(
        method = "raycast(Lnet/minecraft/world/World;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/RaycastContext$FluidHandling;)Lnet/minecraft/util/hit/BlockHitResult;",
        require = 4, allow = 4, at = @At(value = "CONSTANT", args = {"doubleValue=5.0"})
    )
    private static double getActualReachDistance(final double reachDistance, final World world, final PlayerEntity player) {
        return ReachEntityAttributes.getReachDistance(player, reachDistance);
    }
}
