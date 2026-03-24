package com.catchersmittsoftware.kanjiemojigame

class WasmPlatform : com.catchersmittsoftware.kanjiemojigame.Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform =
    _root_ide_package_.com.catchersmittsoftware.kanjiemojigame.WasmPlatform()