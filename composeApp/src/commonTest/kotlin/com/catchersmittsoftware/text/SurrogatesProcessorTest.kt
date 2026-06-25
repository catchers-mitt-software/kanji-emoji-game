package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class SurrogatesProcessorTest {

    private fun chooseNonBMPCodePoint(): Int = Random.nextInt(0x1F300, 0x1FBFA)

    private fun chooseHighSurrogate(): Char {
        return if (Random.nextBoolean()) {
            0xD83C.toChar()
        } else {
            0xD83D.toChar()
        }
    }

    private fun chooseLowSurrogate(): Char =
        Random.nextInt(0xDE00, 0xDF00).toChar()

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
    fun testShiftedMinimumSupplementaryConstant() {
        val expected = 0x10000 ushr 10
        val actual = SurrogatesProcessor.SHIFTED_MIN_SUPP
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

}
