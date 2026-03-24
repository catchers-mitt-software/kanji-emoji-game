package com.catchersmittsoftware.kanjiemojigame

class JVMPlatform : com.catchersmittsoftware.kanjiemojigame.Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform =
    _root_ide_package_.com.catchersmittsoftware.kanjiemojigame.JVMPlatform()