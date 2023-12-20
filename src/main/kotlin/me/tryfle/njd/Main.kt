package me.tryfle.njd

import me.tryfle.njd.commands.ToggleCommand
import me.tryfle.njd.function.NoJumpDelay
import net.weavemc.loader.api.ModInitializer
import net.weavemc.loader.api.command.CommandBus
import net.weavemc.loader.api.event.EventBus
import net.weavemc.loader.api.event.StartGameEvent

class Main: ModInitializer {
    override fun preInit() {
        println("[NJD] Initialized.")
        CommandBus.register(ToggleCommand())
        EventBus.subscribe(StartGameEvent.Post::class.java) {
            EventBus.subscribe(NoJumpDelay())
        }
    }
}
