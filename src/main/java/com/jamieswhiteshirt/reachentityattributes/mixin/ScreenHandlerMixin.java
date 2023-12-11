package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ScreenHandler.class)
abstract class ScreenHandlerMixin {
    @ModifyExpressionValue(
        method = "method_17696(Lnet/minecraft/block/Block;Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Ljava/lang/Boolean;",
        require = 1, allow = 1, at = @At(value = "CONSTANT", args = {"doubleValue=64.0"})
    )
    private static double getActualReachDistance(final double reachDistance, final Block block, final PlayerEntity player) {
        return ReachEntityAttributes.getSquaredReachDistance(player, reachDistance);
    }
}
