package com.catchersmittsoftware.text

object SurrogatesProcessor {

    const val MINIMUM_HIGH_SURROGATE = '\uD800'

    // TODO: Write tests for this
    const val MINIMUM_LOW_SURROGATE = '?'

    // TODO: Write tests for this
    const val MINIMUM_SUPPLEMENTARY = '?'

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
