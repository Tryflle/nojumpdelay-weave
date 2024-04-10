package me.tryfle.njd

import me.tryfle.njd.event.InitEvent
import me.tryfle.njd.function.ChatListener
import net.weavemc.api.ModInitializer
import net.weavemc.api.event.EventBus
import java.lang.instrument.Instrumentation

class Main: ModInitializer {

    override fun preInit(inst: Instrumentation) {
        println("[NJD] Initialized.")
        EventBus.subscribe(InitEvent::class.java) {
            println("[NJD] Init event called.")
            init()
        }
    }

    private fun init() {
        EventBus.subscribe(ChatListener())
    }

    companion object {
        var njdToggled = false
    }
}
