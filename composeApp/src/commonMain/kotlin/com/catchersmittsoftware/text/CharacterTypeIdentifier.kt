package com.catchersmittsoftware.text

// TODO: Refactor to be more elegant
fun isCJKIdeographic(ch: Char): Boolean {
    return if (ch in '\u3220'..'\u3247') {
        true
    } else (ch in ('\u3280'..<'\u32CC')) || (ch == '\u32FF') ||
            (ch in ('\u3358' .. '\u3370')) || (ch in ('\u337B' .. '\u337E')) ||
            (ch > '\u4DFF')
}

// TODO: Write tests for this
fun isCJKIdeographic(ch: WideChar): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: Char): Boolean = false

// TODO: Write tests for this
fun isEmoji(ch: WideChar): Boolean = false
