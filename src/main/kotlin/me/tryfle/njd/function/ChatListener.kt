package me.tryfle.njd.function

import me.tryfle.njd.Main.Companion.njdToggled
import me.tryfle.njd.event.ChatEvent
import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.weavemc.api.event.SubscribeEvent

class ChatListener {

    @SubscribeEvent
    fun onChat(e: ChatEvent) {
        if (e.message.startsWith("/njd")) {
            e.cancelled = true
            njdToggled = !njdToggled
            Minecraft.getMinecraft()?.thePlayer?.addChatMessage(ChatComponentText("${EnumChatFormatting.AQUA}[NJD] Toggled " + if (njdToggled) "on." else "off."))
        }
    }
}