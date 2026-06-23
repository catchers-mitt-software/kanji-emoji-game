package com.catchersmittsoftware.text

// TODO: Write tests for this
fun assembleFromSurrogates(pair: Pair<Char, Char>): WideChar {
    return WideChar(0x10002)
}

// TODO: Write tests for this
fun breakIntoSurrogates(codePoint: Int): Pair<Char, Char> {
    return Pair('?', 'X')
}
