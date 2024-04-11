plugins {
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.0.0-PRE2"
}

group = "me.tryfle"
version = "2.0"

weave {
    configure {
        name = "njd"
        modId = "njd"
        entryPoints = listOf("me.tryfle.njd.Main")
        hooks = listOf("me.tryfle.njd.hook.EntityLivingBaseHook", "me.tryfle.njd.hook.InitEventHook", "me.tryfle.njd.hook.ChatEventHook")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    mavenCentral()
    maven("https://repo.weavemc.dev/releases")
}

dependencies {
    implementation("net.weavemc.api:common:1.0.0-PRE2")
    implementation("net.weavemc:internals:1.0.0-PRE2")
}

kotlin {
    jvmToolchain(17)
}