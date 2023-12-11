package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BrushItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(BrushItem.class)
public class BrushItemMixin {

    @ModifyExpressionValue(
            method = "getHitResult",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/player/PlayerEntity;getReachDistance(Z)F"
            )
    )
    private float getActualReachDistance(float reachDistance, PlayerEntity player) {
        if (player != null) {
            return (float) ReachEntityAttributes.getReachDistance(player, reachDistance);
        }
        return reachDistance;
    }
}
