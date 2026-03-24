package com.catchersmittsoftware.games.kanjiemoji

class JVMPlatform : com.catchersmittsoftware.games.kanjiemoji.Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform =
    _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.JVMPlatform()