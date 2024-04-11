package me.tryfle.njd.hook

import me.tryfle.njd.Main
import net.weavemc.api.Hook
import net.weavemc.internals.asm
import net.weavemc.internals.internalNameOf
import org.objectweb.asm.tree.*

class EntityLivingBaseHook : Hook("net/minecraft/entity/EntityLivingBase") {

    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        node.methods.find { it.name == "onLivingUpdate" }?.instructions?.insert(asm {
            val end = LabelNode()
            invokestatic(internalNameOf<Main>(), "getNjdToggled", "()Z")
            ifeq(end)

            aload(0)
            iconst_0
            putfield("net/minecraft/entity/EntityLivingBase", "jumpTicks", "I")

            +end
        })
    }
}