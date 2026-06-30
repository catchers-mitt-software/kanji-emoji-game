package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

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

    @Test
    fun testToStringSecondAuxConstructor() {
        val codePoint = pickNonBMPCodepoint()
        val high = SurrogatesProcessor.highSurrogate(codePoint)
        val low = SurrogatesProcessor.lowSurrogate(codePoint)
        val pair = Pair(high, low)
        val instance = WideChar(pair)
        val expected = convertToSurrogatePairString(codePoint)
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testReferentialEquality() {
        val codePoint = pickNonBMPCodepoint()
        val instance = WideChar(codePoint)
        assertEquals(instance, instance)
    }

    @Test
    fun testNotEqualsNull() {
        val codePoint = pickNonBMPCodepoint()
        val instance = WideChar(codePoint)
        val message = "$instance should not be equal to null"
        assertFalse(instance.equals(null), message)
    }

    @Test
    fun testNotEqualsDiffClass() {
        val codePoint = pickNonBMPCodepoint()
        val instance = WideChar(codePoint)
        val message = "$instance should not be equal to instance of other class"
        assertFalse(instance.equals(this), message)
    }

    @Test
    fun testNotEqualsDiffCodePoint() {
        val codePointA = pickNonBMPCodepoint()
        val codePointB = codePointA + 1
        val instanceA = WideChar(codePointA)
        val instanceB = WideChar(codePointB)
        val message = "$instanceA should not equal $instanceB"
        assertFalse(instanceA.equals(instanceB), message)
    }

    @Test
    fun testNotEqualsDiffChar() {
        val characterA = pickBMPKanji()
        val characterB = characterA + 1
        val instanceA = WideChar(characterA)
        val instanceB = WideChar(characterB)
        val message = "$instanceA should not equal $instanceB"
        assertFalse(instanceA.equals(instanceB), message)
    }

}
