package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class SurrogatesProcessorTest {

    private fun chooseHighSurrogate(): Char {
        return if (Random.nextBoolean()) {
            0xD83C.toChar()
        } else {
            0xD83D.toChar()
        }
    }

    private fun chooseLowSurrogate(): Char =
        Random.nextInt(0xDE00, 0xDF00).toChar()

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

}
