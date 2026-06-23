package com.catchersmittsoftware.text

object SurrogatesProcessor {

    const val MINIMUM_HIGH_SURROGATE = '\uD800'

    const val MINIMUM_LOW_SURROGATE = '\uDC00'

    const val MINIMUM_SUPPLEMENTARY = 65536

    // TODO: Write tests for this
    // TODO: Write tests for this
    fun assembleFromSurrogates(pair: Pair<Char, Char>): WideChar {
        return WideChar(0x10002)
    }

    // TODO: Write tests for this
    fun breakIntoSurrogates(codePoint: Int): Pair<Char, Char> {
        return Pair('?', 'X')
    }

}
