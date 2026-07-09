package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    return if (ch in '\u3220'..'\u3247') {
        true
    } else {
        ch > '\u32B0'
    }
}

// TODO: Write tests for this
fun isCJKIdeographic(ch: WideChar): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: Char): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: WideChar): Boolean = false
