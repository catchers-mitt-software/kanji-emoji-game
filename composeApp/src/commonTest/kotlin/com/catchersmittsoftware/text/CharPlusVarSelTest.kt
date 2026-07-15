package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class CharPlusVarSelTest {

    private fun chooseBMPMiscSymbol(): Char =
        Random.nextInt(0x2600, 0x2700).toChar()

    private fun chooseVarSel(): Byte = Random.nextInt(0x10).toByte()

    @Test
    fun testToString() {
        val character = WideChar(chooseBMPMiscSymbol())
        val selector = 0x0F.toByte()
        val instance = CharPlusVarSel(character, selector)
        val expected = character.toString() + (0xFE00 + selector).toChar()
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

    @Test
    fun testToStringAuxConstructor() {
        val character = chooseBMPMiscSymbol()
        val selector = 0x0F.toByte()
        val instance = CharPlusVarSel(character, selector)
        val array = charArrayOf(character, (0xFE00 + selector).toChar())
        val expected = array.concatToString()
        val actual = instance.toString()
        assertEquals(expected, actual)
    }

}
