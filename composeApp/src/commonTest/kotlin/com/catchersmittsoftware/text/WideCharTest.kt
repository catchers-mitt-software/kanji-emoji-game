package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class WideCharTest {

    fun pickBMPKanji(): Char {
        return Random.nextInt(0x4E00, 0xA000).toChar()
    }

    fun pickNonBMPCodepoint(): Int {
        return Random.nextInt(0x17000, 0x18CD5)
    }

    @Test
    fun testToStringAuxConstructor() {
        val ch = pickBMPKanji()
        val instance = WideChar(ch)
        val expected = ch.toString()
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

}
