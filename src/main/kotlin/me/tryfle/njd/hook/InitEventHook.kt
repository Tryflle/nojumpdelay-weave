package me.tryfle.njd.hook

import me.tryfle.njd.event.InitEvent
import net.weavemc.api.Hook
import net.weavemc.api.event.Event
import net.weavemc.api.event.EventBus
import net.weavemc.internals.asm
import net.weavemc.internals.internalNameOf
import net.weavemc.internals.named
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.Opcodes.RETURN

class InitEventHook : Hook("net/minecraft/client/Minecraft") {

    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        val initMethod = node.methods.named("startGame")
        initMethod.instructions.insertBefore(initMethod.instructions.findLast {it.opcode == RETURN}, asm {
            new(internalNameOf<InitEvent>())
            dup
            invokespecial(internalNameOf<InitEvent>(), "<init>", "()V")
            invokestatic(
                internalNameOf<EventBus>(),
                "postEvent",
                "(L${internalNameOf<Event>()};)V"
            )
        })
    }
}