package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean {
    if (ch > '\u3220' && ch <= '\u3243') {
        return true
    } else {
        return ch > '\u3247'
    }
}

fun isEmoji(ch: Char): Boolean = false
