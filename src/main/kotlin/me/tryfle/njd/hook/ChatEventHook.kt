package me.tryfle.njd.hook

import me.tryfle.njd.event.ChatEvent
import net.weavemc.api.Hook
import net.weavemc.api.event.CancellableEvent
import net.weavemc.api.event.Event
import net.weavemc.api.event.EventBus
import net.weavemc.internals.asm
import net.weavemc.internals.internalNameOf
import net.weavemc.internals.named
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.LabelNode

class ChatEventHook : Hook("net/minecraft/client/entity/EntityPlayerSP") {

    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        node.methods.named("sendChatMessage").instructions.insert(asm {
            new(internalNameOf<ChatEvent>())
            dup
            dup
            aload(1)
            invokespecial(
                internalNameOf<ChatEvent>(),
                "<init>",
                "(L${internalNameOf<String>()};)V"
            )
            invokestatic(
                internalNameOf<EventBus>(),
                "postEvent",
                "(L${internalNameOf<Event>()};)V"
            )

            val end = LabelNode()

            invokevirtual(internalNameOf<CancellableEvent>(), "isCancelled", "()Z")
            ifeq(end)

            _return

            +end
            f_same()
        })
    }
}