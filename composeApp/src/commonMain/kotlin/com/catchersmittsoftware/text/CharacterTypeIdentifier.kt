package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u321E'

fun isEmoji(ch: Char): Boolean = false
