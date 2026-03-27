package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u3220'

fun isEmoji(ch: Char): Boolean = false
