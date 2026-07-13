package com.catchersmittsoftware.games.kanjiemoji

import com.catchersmittsoftware.text.WideChar

// TODO: Refactor as a data class once all tests are passing
class KanjiEmojiPair(val kanji: Char, val emoji: WideChar) {

    override fun toString(): String = "($kanji, $emoji)"

    // TODO: Write tests for this
    override fun equals(other: Any?): Boolean = false

    // TODO: Write tests for this
    override fun hashCode(): Int = 0
    
}
