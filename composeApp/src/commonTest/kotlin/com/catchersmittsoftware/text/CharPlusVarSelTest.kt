package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals

class CharPlusVarSelTest {

    private fun chooseBMPMiscSymbol(): Char =
        Random.nextInt(0x2600, 0x2700).toChar()

    private fun chooseVarSel(): Byte = Random.nextInt(0x10).toByte()

    // TODO: Write toString() test for aux constructor

}
