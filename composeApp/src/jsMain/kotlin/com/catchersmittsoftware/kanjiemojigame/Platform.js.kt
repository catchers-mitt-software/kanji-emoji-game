package com.catchersmittsoftware.kanjiemojigame

class JsPlatform : com.catchersmittsoftware.kanjiemojigame.Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform =
    _root_ide_package_.com.catchersmittsoftware.kanjiemojigame.JsPlatform()