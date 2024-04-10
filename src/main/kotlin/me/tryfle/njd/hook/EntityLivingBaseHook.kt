package me.tryfle.njd.hook

import me.tryfle.njd.Main
import net.minecraft.entity.EntityLivingBase
import net.weavemc.api.Hook
import net.weavemc.internals.asm
import net.weavemc.internals.internalNameOf
import org.objectweb.asm.tree.*

class EntityLivingBaseHook : Hook("net/minecraft/entity/EntityLivingBase") {

    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        node.methods.find { it.name == "onLivingUpdate" }?.instructions?.insert(asm {
            val end = LabelNode()
            getstatic(internalNameOf<Main>(), "njdToggled", "Z")
            ifeq(end)

            iconst_0
            putfield(internalNameOf<EntityLivingBase>(), "jumpTicks", "I")

            +end
        })
    }
}