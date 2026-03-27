package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u31FF'

fun isEmoji(ch: Char): Boolean = false
