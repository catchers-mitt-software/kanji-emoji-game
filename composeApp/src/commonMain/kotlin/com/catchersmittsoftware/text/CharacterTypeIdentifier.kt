package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    if (ch in '\u3220'..'\u3243') {
        return true
    } else {
        return ch > '\u3247'
    }
}

fun isEmoji(ch: Char): Boolean = false
