package com.catchersmittsoftware.text

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CharacterTypeIdentifierTest {

    private fun chooseLowBMPChar(): Char {
        var propChar = (' ' .. '\u2DFF').random()
        while (!propChar.isDefined()) propChar++
        return propChar
    }

    @Test
    fun testIsCJKIdeographic() {
        println("isCJKIdeographic")
        val ch: Char = ('\u4E00' .. '\u9FFF').random()
        val message = "Character $ch should be CJK ideograph"
        assertTrue(isCJKIdeographic(ch), message)
    }

    @Test
    fun testLowBMPCharIsNotCJKIdeographic() {
        val ch = chooseLowBMPChar()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCJKSymbolsAndPunctuationNotCJKIdeographic() {
        val ch: Char = ('\u3000'..'\u303F').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testHiraganaAreNotCJKIdeographic() {
        val ch: Char = ('\u3041'..'\u309F').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testKatakanaAreNotCJKIdeographic() {
        val ch: Char = ('\u30A0'..'\u30FF').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testBopomofoAreNotCJKIdeographic() {
        val ch: Char = ('\u3105'..'\u312F').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCompatHangulAreNotCJKIdeographic() {
        val ch: Char = ('\u3131'..'\u318E').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    // TODO: Determine if kanbun should be treated as kanji or not

    @Test
    fun testBopomofoExtendedAreNotCJKIdeographic() {
        val ch: Char = ('\u31A0'..'\u31BF').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testKatakanaPhoneticExtensionsAreNotCJKIdeographic() {
        val ch: Char = ('\u31F0'..'\u31FF').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testParenthesizedHangulAreNotCJKIdeographic() {
        val ch: Char = ('\u3200'..'\u321E').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testParenthesizedKanjiAreCJKIdeographic() {
        val ch: Char = ('\u3220'..'\u3243').random()
        val message = "Character $ch should be CJK ideograph"
        assertTrue(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCircledAribStdB24KanjiAreCJKIdeographic() {
        val ch: Char = ('\u3244'..'\u3247').random()
        val message = "Character $ch should be CJK ideograph"
        assertTrue(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCircledNumbersOnBlackSquaresAreNotCJKIdeographic() {
        val ch: Char = ('\u3248'..'\u324F').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testPartnershipSignIsNotCJKIdeographic() {
        val ch = '\u3250'
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCircledNumbersAreNotCJKIdeographic() {
        val ch: Char = ('\u3251'..'\u325F').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

    @Test
    fun testCircledHangulLettersAreNotCJKIdeographic() {
        val ch: Char = ('\u3260'..'\u326D').random()
        val message = "Character $ch should not be CJK ideograph"
        assertFalse(isCJKIdeographic(ch), message)
    }

}
