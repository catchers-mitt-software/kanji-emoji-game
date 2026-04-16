package com.catchersmittsoftware.text

class WideChar(val codePoint: Int) {

    constructor(ch: Char) : this(ch.toInt())

}
