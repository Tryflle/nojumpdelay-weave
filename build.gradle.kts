plugins {
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.0.0-PRE"
}

group = "me.tryfle"
version = "1.0"

minecraft {
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
    implementation("net.weavemc.api:common:1.0.0-PRE")
    implementation("net.weavemc:internals:1.0.0-PRE")
}

kotlin {
    jvmToolchain(17)
}