package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    if (ch in '\u3220'..'\u3247') {
        return true
    } else {
        return ch > '\u324F'
    }
}

fun isEmoji(ch: Char): Boolean = false
