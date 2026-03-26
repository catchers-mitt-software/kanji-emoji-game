package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u30FF'

fun isEmoji(ch: Char): Boolean = false
