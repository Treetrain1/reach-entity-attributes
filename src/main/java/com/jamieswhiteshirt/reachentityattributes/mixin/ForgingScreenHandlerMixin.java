package com.jamieswhiteshirt.reachentityattributes.mixin;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.ForgingScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ForgingScreenHandler.class)
abstract class ForgingScreenHandlerMixin extends ScreenHandler {
    ForgingScreenHandlerMixin(final ScreenHandlerType<?> type, final int id) {
        super(type, id);
    }

    @ModifyExpressionValue(
        method = "method_24924(Lnet/minecraft/entity/player/PlayerEntity;Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)Ljava/lang/Boolean;",
        at = @At(value = "CONSTANT", args = {"doubleValue=64.0"})
    )
    private double getActualReachDistance(final double reachDistance, final PlayerEntity player) {
        return ReachEntityAttributes.getSquaredReachDistance(player, reachDistance);
    }
}
