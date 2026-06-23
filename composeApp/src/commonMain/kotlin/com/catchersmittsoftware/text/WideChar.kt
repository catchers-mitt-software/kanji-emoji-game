package com.catchersmittsoftware.text

// TODO: Convert to data class after all tests are passing
class WideChar(val codePoint: Int) {

    override fun toString(): String {
        return this.codePoint.toString()
    }

    // TODO: Write tests for this
    override fun equals(other: Any?): Boolean {
        return false
    }

    // TODO: Write tests for this
    override fun hashCode(): Int {
        return Int.MAX_VALUE
    }

    constructor(ch: Char) : this(ch.code)

    // TODO: Write tests for this
    constructor(pair: Pair<Char, Char>) : this(0x10001)

}
