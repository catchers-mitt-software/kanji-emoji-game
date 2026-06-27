package com.catchersmittsoftware.text

object SurrogatesProcessor {

    const val MINIMUM_HIGH_SURROGATE = '\uD800'

    const val MINIMUM_LOW_SURROGATE = '\uDC00'

    const val MINIMUM_SUPPLEMENTARY = 65536

    const val HIGH_SURROGATE_ADJUST = 55232

    const val LOW_SURROGATE_MASK = 1023

    fun highSurrogate(codePoint: Int): Char =
        ((codePoint shr 10) + HIGH_SURROGATE_ADJUST).toChar()

    fun lowSurrogate(codePoint: Int): Char =
        (MINIMUM_LOW_SURROGATE + (codePoint and LOW_SURROGATE_MASK))

    fun breakIntoSurrogates(codePoint: Int): Pair<Char, Char> {
        val high = this.highSurrogate(codePoint)
        val low = this.lowSurrogate(codePoint)
        return Pair(high, low)
    }

    // TODO: Write tests for this
    fun assembleFromSurrogates(pair: Pair<Char, Char>): WideChar {
        return WideChar(0x10002)
    }

}
