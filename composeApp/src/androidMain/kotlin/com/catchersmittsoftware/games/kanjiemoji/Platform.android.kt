package com.catchersmittsoftware.games.kanjiemoji

import android.os.Build

class AndroidPlatform : com.catchersmittsoftware.games.kanjiemoji.Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform =
    _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.AndroidPlatform()