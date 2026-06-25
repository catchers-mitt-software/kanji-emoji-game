package com.catchersmittsoftware.text

object SurrogatesProcessor {

    const val MINIMUM_HIGH_SURROGATE = '\uD800'

    const val MINIMUM_LOW_SURROGATE = '\uDC00'

    const val MINIMUM_SUPPLEMENTARY = 65536

    const val SHIFTED_MIN_SUPP = 64

    // TODO: Write tests for this
    fun highSurrogate(codePoint: Int): Char = 'H'

    // TODO: Write tests for this
    fun lowSurrogate(codePoint: Int): Char = 'L'

    // TODO: Write tests for this
    fun breakIntoSurrogates(codePoint: Int): Pair<Char, Char> {
        return Pair('?', 'X')
    }

    // TODO: Write tests for this
    fun assembleFromSurrogates(pair: Pair<Char, Char>): WideChar {
        return WideChar(0x10002)
    }

}
