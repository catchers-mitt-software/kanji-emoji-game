package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    return if (ch in '\u3220'..'\u3247') {
        true
    } else {
        ch > '\u327B'
    }
}

fun isEmoji(ch: Char): Boolean = false
