package me.tryfle.njd.function

import me.tryfle.njd.commands.ToggleCommand
import net.minecraft.client.Minecraft
import net.weavemc.loader.api.event.SubscribeEvent
import net.weavemc.loader.api.event.TickEvent

class NoJumpDelay {
    @SubscribeEvent
    fun onTick(e: TickEvent) {
        if (Minecraft.getMinecraft().thePlayer != null && Minecraft.getMinecraft().thePlayer.onGround && ToggleCommand.enabled) {
            Minecraft.getMinecraft().thePlayer.jumpTicks = 0
        }
    }
}