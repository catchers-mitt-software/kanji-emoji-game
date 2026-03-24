package com.catchersmittsoftware.kanjiemojigame

import platform.UIKit.UIDevice

class IOSPlatform : com.catchersmittsoftware.kanjiemojigame.Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform =
    _root_ide_package_.com.catchersmittsoftware.kanjiemojigame.IOSPlatform()