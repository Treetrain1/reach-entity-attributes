package com.jamieswhiteshirt.reachentityattributes.mixin.client;

import com.jamieswhiteshirt.reachentityattributes.ReachEntityAttributes;
import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ClientPlayerInteractionManager.class)
abstract class ClientPlayerInteractionManagerMixin {
    @Shadow @Final private MinecraftClient client;

    @ModifyReturnValue(
        method = "getReachDistance()F",
        at = @At("RETURN")
    )
    private float getActualReachDistance(final float reachDistance) {
        if (this.client.player != null) {
            return (float) ReachEntityAttributes.getReachDistance(this.client.player, reachDistance);
        }
        return reachDistance;
    }
}
