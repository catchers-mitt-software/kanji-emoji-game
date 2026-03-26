package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u2FFF'

fun isEmoji(ch: Char): Boolean = false
