package com.catchersmittsoftware.games.kanjiemoji

class Greeting {
    private val platform = _root_ide_package_.com.catchersmittsoftware.games.kanjiemoji.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}