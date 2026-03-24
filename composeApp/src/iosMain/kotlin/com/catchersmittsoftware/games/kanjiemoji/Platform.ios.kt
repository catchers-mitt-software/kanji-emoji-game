package com.catchersmittsoftware.games.kanjiemoji

import platform.UIKit.UIDevice

class IOSPlatform : com.catchersmittsoftware.games.kanjiemoji.Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform =
    _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.IOSPlatform()