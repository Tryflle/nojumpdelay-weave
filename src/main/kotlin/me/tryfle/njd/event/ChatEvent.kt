package me.tryfle.njd.event

import net.weavemc.api.event.CancellableEvent

class ChatEvent(val message: String) : CancellableEvent()