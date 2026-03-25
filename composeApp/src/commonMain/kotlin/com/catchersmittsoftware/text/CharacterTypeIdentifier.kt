package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u4DFF'

fun isEmoji(ch: Char): Boolean = false
