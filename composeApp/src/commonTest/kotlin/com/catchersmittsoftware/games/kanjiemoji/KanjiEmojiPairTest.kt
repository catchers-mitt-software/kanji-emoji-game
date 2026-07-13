package com.catchersmittsoftware.games.kanjiemoji

import com.catchersmittsoftware.text.SurrogatesProcessor
import com.catchersmittsoftware.text.WideChar

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Test
    fun testToString() {
        val kanji = chooseKanji()
        val emoji = chooseEmoji()
        val instance = KanjiEmojiPair(kanji, emoji)
        val actual = instance.toString()
        val message = "\"$actual\" should contain '$kanji' and '$emoji'"
        assertTrue(actual.contains(kanji), message)
        assertTrue(actual.contains(emoji.toString()), message)
    }

    @Test
    fun testReferentialEquality() {
        val kanji = chooseKanji()
        val emoji = chooseEmoji()
        val instance = KanjiEmojiPair(kanji, emoji)
        val message = "$instance should be equal to itself"
        assertTrue(instance.equals(instance), message)
    }

    @Test
    fun testNotEqualsNull() {
        val kanji = chooseKanji()
        val emoji = chooseEmoji()
        val instance = KanjiEmojiPair(kanji, emoji)
        val other = null
        val message = "$instance should not equal null"
        assertFalse(instance.equals(other), message)
    }

    @Test
    fun testNotEqualsDiffClass() {
        val kanji = chooseKanji()
        val emoji = chooseEmoji()
        val instance = KanjiEmojiPair(kanji, emoji)
        val message = "$instance should not equal $this"
        assertFalse(instance.equals(this), message)
    }

}
