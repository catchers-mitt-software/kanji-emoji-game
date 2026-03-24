package com.catchersmittsoftware.games.kanjiemoji

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}