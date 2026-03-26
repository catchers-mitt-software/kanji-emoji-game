package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u303F'

fun isEmoji(ch: Char): Boolean = false
