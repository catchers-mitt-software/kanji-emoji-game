package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class WideCharTest {

    private fun pickBMPKanji(): Char {
        return Random.nextInt(0x4E00, 0xA000).toChar()
    }

    private fun pickNonBMPCodepoint(): Int {
        return Random.nextInt(0x1F300, 0x1F600)
    }

    private fun convertToSurrogatePairString(codePoint: Int): String {
        val high = SurrogatesProcessor.highSurrogate(codePoint)
        val low = SurrogatesProcessor.lowSurrogate(codePoint)
        val surrogates = charArrayOf(high, low)
        return surrogates.concatToString()
    }

    @Test
    fun testToStringAuxConstructor() {
        val ch = pickBMPKanji()
        val instance = WideChar(ch)
        val expected = ch.toString()
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testToString() {
        val codePoint = pickNonBMPCodepoint()
        val instance = WideChar(codePoint)
        val expected = convertToSurrogatePairString(codePoint)
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

}
