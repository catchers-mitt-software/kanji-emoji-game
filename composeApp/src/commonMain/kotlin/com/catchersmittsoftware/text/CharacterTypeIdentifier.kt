package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u3247'

fun isEmoji(ch: Char): Boolean = false
