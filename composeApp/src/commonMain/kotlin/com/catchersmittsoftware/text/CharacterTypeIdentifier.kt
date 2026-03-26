package com.catchersmittsoftware.text

fun isCJKIdeographic(ch: Char): Boolean = ch > '\u312F'

fun isEmoji(ch: Char): Boolean = false
