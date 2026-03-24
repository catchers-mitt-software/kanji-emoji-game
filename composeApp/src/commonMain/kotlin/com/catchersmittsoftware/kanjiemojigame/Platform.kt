package com.catchersmittsoftware.kanjiemojigame

interface Platform {
    val name: String
}

expect fun getPlatform(): com.catchersmittsoftware.kanjiemojigame.Platform