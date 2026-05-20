package com.catchersmittsoftware.text

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class WideCharTest {

    fun pickNonBMPCodepoint(): Int {
        return Random.nextInt(0x17000, 0x18CD5)
    }

}
