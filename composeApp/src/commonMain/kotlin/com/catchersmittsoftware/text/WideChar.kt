package com.catchersmittsoftware.text

data class WideChar(val codePoint: Int) {

    override fun toString(): String {
        if (this.codePoint < 0x10000) {
            return this.codePoint.toChar().toString()
        } else {
            val high = SurrogatesProcessor.highSurrogate(this.codePoint)
            val low = SurrogatesProcessor.lowSurrogate(this.codePoint)
            val surrogates = charArrayOf(high, low)
            return surrogates.concatToString()
        }
    }

    constructor(ch: Char) : this(ch.code)

    constructor(pair: Pair<Char, Char>)
            : this(SurrogatesProcessor.reckonCodePoint(pair))

}
