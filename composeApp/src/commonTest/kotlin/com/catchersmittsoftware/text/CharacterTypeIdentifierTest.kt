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

}
