package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.VehicleInventory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VehicleInventory.class)
interface VehicleInventoryValidationMixin {
    @ModifyExpressionValue(
        method = "canPlayerAccess(Lnet/minecraft/entity/player/PlayerEntity;)Z",
        at = @At(value = "CONSTANT", args = {"doubleValue=8.0"})
    )
    private static double getActualReachDistance(final double reachDistance, final PlayerEntity player) {
        return ReachEntityAttributes.getReachDistance(player, reachDistance);
    }
}
