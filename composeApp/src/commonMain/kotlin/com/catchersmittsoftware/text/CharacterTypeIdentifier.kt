package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u309F'

fun isEmoji(ch: Char): Boolean = false
