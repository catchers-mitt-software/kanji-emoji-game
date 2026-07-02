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

    private fun chooseHighSurrogate(): Char =
        Random.nextInt(0xD83C, 0xD83F).toChar()

    private fun chooseLowSurrogate(): Char =
        Random.nextInt(0xDE00, 0xDF00).toChar()

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

    @Test
    fun testNotEqualsDiffHighSurr() {
        val highA = chooseHighSurrogate()
        val highB = highA + 1
        val low = chooseLowSurrogate()
        val pairA = Pair(highA, low)
        val pairB = Pair(highB, low)
        val instanceA = WideChar(pairA)
        val instanceB = WideChar(pairB)
        val message =
            "$instanceA from $pairA should not equal $instanceB from $pairB"
        assertFalse(instanceA.equals(instanceB), message)
    }

    @Test
    fun testNotEqualsDiffLowSurr() {
        val high = chooseHighSurrogate()
        val lowA = chooseLowSurrogate()
        val lowB = lowA + 1
        val pairA = Pair(high, lowA)
        val pairB = Pair(high, lowB)
        val instanceA = WideChar(pairA)
        val instanceB = WideChar(pairB)
        val message =
            "$instanceA from $pairA should not equal $instanceB from $pairB"
        assertNotEquals(instanceA, instanceB, message)
    }

    @Test
    fun testEquals() {
        val codePoint = pickNonBMPCodepoint()
        val someChar = WideChar(codePoint)
        val sameChar = WideChar(codePoint)
        val message = "$someChar should equal $sameChar"
        assertEquals(someChar, sameChar, message)
    }

    @Test
    fun testEqualsSameChar() {
        val ch = pickBMPKanji()
        val someChar = WideChar(ch)
        val sameChar = WideChar(ch)
        val message = "$someChar should equal $sameChar"
        assertEquals(someChar, sameChar, message)
    }

    @Test
    fun testEqualsSamePair() {
        val high = chooseHighSurrogate()
        val low = chooseLowSurrogate()
        val pair = Pair(high, low)
        val someChar = WideChar(pair)
        val sameChar = WideChar(pair)
        val message = "$someChar should equal $sameChar"
        assertEquals(someChar, sameChar, message)
    }

    @Test
    fun testEqualsPrimaryConstructorCharAuxConstructor() {
        val ch = pickBMPKanji()
        val codePoint = ch.code
        val someChar = WideChar(codePoint)
        val sameChar = WideChar(ch)
        val message = "$someChar should equal $sameChar"
        assertEquals(someChar, sameChar, message)
    }

}
