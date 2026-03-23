package com.gettsmartapp.kanjiemojigame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform