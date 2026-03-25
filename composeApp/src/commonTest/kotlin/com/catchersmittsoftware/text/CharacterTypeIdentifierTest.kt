package com.catchersmittsoftware.text

import com.catchersmittsoftware.text.isCJKIdeographic

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CharacterTypeIdentifierTest {

    @Test
    fun testIsCJKIdeographic() {
        println("isCJKIdeographic")
        val ch: Char = ('\u4E00' .. '\u9FFF').random()
        val message = "Character $ch should be CJK ideograph"
        assertTrue(isCJKIdeographic(ch), message)
    }

}
