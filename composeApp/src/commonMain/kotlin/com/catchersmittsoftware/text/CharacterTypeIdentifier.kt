package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    return if (ch in '\u3220'..'\u3247') {
        true
    } else (ch in ('\u3280'..<'\u32CC')) || (ch in ('\u32D0' .. '\u32FE')) ||
            (ch > '\u4DFF')
}

// TODO: Write tests for this
fun isCJKIdeographic(ch: WideChar): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: Char): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: WideChar): Boolean = false
