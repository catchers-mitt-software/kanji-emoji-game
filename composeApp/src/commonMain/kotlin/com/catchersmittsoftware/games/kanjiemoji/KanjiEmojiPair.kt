package com.catchersmittsoftware.games.kanjiemoji

import com.catchersmittsoftware.text.WideChar

// TODO: Refactor as a data class once all tests are passing
class KanjiEmojiPair(val kanji: Char, val emoji: WideChar) {

    override fun toString(): String = "($kanji, $emoji)"

    override fun equals(other: Any?): Boolean = if (other is KanjiEmojiPair) {
        return this.kanji == other.kanji && this.emoji == other.emoji
    } else {
        return false
    }

    override fun hashCode(): Int = (kanji.hashCode() shl 16) + emoji.hashCode()
    
}
