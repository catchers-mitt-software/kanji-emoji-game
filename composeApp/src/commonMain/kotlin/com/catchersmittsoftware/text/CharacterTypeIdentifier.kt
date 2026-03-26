package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u318E'

fun isEmoji(ch: Char): Boolean = false
