package me.tryfle.njd.commands

import net.minecraft.client.Minecraft
import net.minecraft.util.ChatComponentText
import net.minecraft.util.EnumChatFormatting
import net.weavemc.loader.api.command.Command

class ToggleCommand: Command("njd") {
    override fun handle(args: Array<out String>) {
        enabled = !enabled
        Minecraft.getMinecraft().thePlayer.addChatMessage(ChatComponentText(EnumChatFormatting.AQUA.toString() + "[NJD] Toggled " + if (enabled) "on." else "off"))
    }

    companion object {
        var enabled: Boolean = false
    }
}