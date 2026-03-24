package com.catchersmittsoftware.games.kanjiemoji

class WasmPlatform : com.catchersmittsoftware.games.kanjiemoji.Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform =
    _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.WasmPlatform()