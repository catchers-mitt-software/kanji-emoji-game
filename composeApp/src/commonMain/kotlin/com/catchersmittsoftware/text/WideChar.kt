package com.catchersmittsoftware.text

// TODO: Convert to data class after all tests are passing
class WideChar(val codePoint: Int) {

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

    override fun equals(other: Any?): Boolean {
        return other != null
    }

    // TODO: Write tests for this
    override fun hashCode(): Int {
        return Int.MAX_VALUE
    }

    constructor(ch: Char) : this(ch.code)

    constructor(pair: Pair<Char, Char>)
            : this(SurrogatesProcessor.reckonCodePoint(pair))

}
