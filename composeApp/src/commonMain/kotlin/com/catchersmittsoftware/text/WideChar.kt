package com.catchersmittsoftware.text

class WideChar(val codePoint: Int) {

    override fun toString(): String {
        return this.codePoint.toChar().toString()
    }

    constructor(ch: Char) : this(ch.code)

}
