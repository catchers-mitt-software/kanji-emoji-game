package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class SurrogatesProcessorTest {

    private fun chooseNonBMPCodePoint(): Int = Random.nextInt(0x1F300, 0x1FBFA)

    private fun reckonHighSurrogate(codePoint: Int): Char {
        val shifted = codePoint ushr 10
        return (0xD7C0 + shifted).toChar()
    }

    private fun reckonLowSurrogate(codePoint: Int): Char {
        val masked = codePoint and 0x3FF
        return (0xDC00 + masked).toChar()
    }

    @Test
    fun testMinimumHighSurrogateConstant() {
        val expected = '\uD800'
        val actual = SurrogatesProcessor.MINIMUM_HIGH_SURROGATE
        assertEquals(expected, actual)
    }

    @Test
    fun testMinimumLowSurrogateConstant() {
        val expected = '\uDC00'
        val actual = SurrogatesProcessor.MINIMUM_LOW_SURROGATE
        assertEquals(expected, actual)
    }

    @Test
    fun testMinimumSupplementaryConstant() {
        val expected = 0x10000
        val actual = SurrogatesProcessor.MINIMUM_SUPPLEMENTARY
        assertEquals(expected, actual)
    }

    @Test
    fun testHighSurrogateAdjustConstant() {
        val expected = 0xD7C0
        val actual = SurrogatesProcessor.HIGH_SURROGATE_ADJUST
        assertEquals(expected, actual)
    }

    @Test
    fun testLowSurrogateMaskConstant() {
        val expected = 0x3FF
        val actual = SurrogatesProcessor.LOW_SURROGATE_MASK
        assertEquals(expected, actual)
    }

    @Test
    fun testHighSurrogate() {
        val codePoint = chooseNonBMPCodePoint()
        val expected = reckonHighSurrogate(codePoint)
        val actual = SurrogatesProcessor.highSurrogate(codePoint)
        val low = reckonLowSurrogate(codePoint)
        val surrogates = charArrayOf(expected, low)
        val emoji = surrogates.concatToString()
        val hexString = "U+${expected.code.toString(16)}"
        val message = "Reckoning high surrogate for $emoji, $hexString"
        assertEquals(expected, actual, message)
    }

    @Test
    fun testLowSurrogate() {
        val codePoint = chooseNonBMPCodePoint()
        val expected = reckonLowSurrogate(codePoint)
        val actual = SurrogatesProcessor.lowSurrogate(codePoint)
        val high = reckonHighSurrogate(codePoint)
        val surrogates = charArrayOf(high, expected)
        val emoji = surrogates.concatToString()
        val hexString = "U+${expected.code.toString(16)}"
        val message = "Reckoning low surrogate for $emoji, $hexString"
        assertEquals(expected, actual, message)
    }

    @Test
    fun testBreakIntoSurrogates() {
        val codePoint = chooseNonBMPCodePoint()
        val high = reckonHighSurrogate(codePoint)
        val low = reckonLowSurrogate(codePoint)
        val expected = Pair(high, low)
        val actual = SurrogatesProcessor.breakIntoSurrogates(codePoint)
        val message =
            "Breaking ${charArrayOf(high, low).concatToString()} to surrogates"
        assertEquals(expected, actual, message)
    }

    @Test
    fun testReckonCodePoint() {
        val expected = chooseNonBMPCodePoint()
        val high = reckonHighSurrogate(expected)
        val low = reckonLowSurrogate(expected)
        val pair = Pair(high, low)
        val actual = SurrogatesProcessor.reckonCodePoint(pair)
        val charStr = charArrayOf(high, low).concatToString()
        val message =
            "Codepoint for $charStr should be U+${expected.toString(16)}"
        assertEquals(expected, actual, message)
    }

    @Test
    fun testAssembleFromSurrogates() {
        val codePoint = chooseNonBMPCodePoint()
        val high = reckonHighSurrogate(codePoint)
        val low = reckonLowSurrogate(codePoint)
        val pair = Pair(high, low)
        val expected = WideChar(codePoint)
        val actual = SurrogatesProcessor.assembleFromSurrogates(pair)
        assertEquals(expected, actual)
    }

}
