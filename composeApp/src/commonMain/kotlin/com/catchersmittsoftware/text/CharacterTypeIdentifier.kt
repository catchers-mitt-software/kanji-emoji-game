package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u31BF'

fun isEmoji(ch: Char): Boolean = false
