package com.catchersmittsoftware.games.kanjiemoji

import com.catchersmittsoftware.text.SurrogatesProcessor
import com.catchersmittsoftware.text.WideChar

import kotlin.test.Test
import kotlin.test.assertEquals

class KanjiEmojiPairTest {

    companion object {

        private const val DEFAULT_HIGH_SURROGATE: Char = '\uD83C'

        private fun chooseKanji(): Char = ('\u4E00' .. '\u9FFF').random()

        private fun chooseDiffKanji(kanji: Char): Char {
            var propChar = kanji
            while (propChar == kanji) propChar = chooseKanji()
            return propChar
        }

        private fun chooseEmoji(): WideChar {
            val low = ('\uDF00' .. '\uDF7F').random()
            return WideChar(Pair(DEFAULT_HIGH_SURROGATE, low))
        }

        private fun chooseDiffEmoji(emoji: WideChar): WideChar {
            var propChar = emoji
            while (propChar == emoji) propChar = chooseEmoji()
            return propChar
        }

    }

}
