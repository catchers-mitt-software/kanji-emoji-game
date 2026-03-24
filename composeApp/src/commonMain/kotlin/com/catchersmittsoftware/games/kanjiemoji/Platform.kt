package com.catchersmittsoftware.games.kanjiemoji

interface Platform {
    val name: String
}

expect fun getPlatform(): com.catchersmittsoftware.games.kanjiemoji.Platform