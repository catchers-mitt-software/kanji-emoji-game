package com.catchersmittsoftware.kanjiemojigame

import android.os.Build

class AndroidPlatform : com.catchersmittsoftware.kanjiemojigame.Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform =
    _root_ide_package_.com.catchersmittsoftware.kanjiemojigame.AndroidPlatform()