package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    if (ch in '\u3220'..'\u3247') {
        return true
    } else {
        return ch > '\u326D'
    }
}

fun isEmoji(ch: Char): Boolean = false
