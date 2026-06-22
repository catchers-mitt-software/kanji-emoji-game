package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class WideCharTest {

    fun pickNonBMPCodepoint(): Int {
        return Random.nextInt(0x17000, 0x18CD5)
    }

    @Test
    fun testToString() {
        val ch = pickNonBMPCodepoint().toChar()
        val instance = WideChar(ch)
        val expected = ch.toString()
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

}
