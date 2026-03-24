package com.catchersmittsoftware.games.kanjiemoji

class JsPlatform : com.catchersmittsoftware.games.kanjiemoji.Platform {
    override val name: String = "Web with Kotlin/JS"
}

actual fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform =
    _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.JsPlatform()