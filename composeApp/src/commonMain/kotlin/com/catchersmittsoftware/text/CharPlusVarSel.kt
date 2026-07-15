package com.catchersmittsoftware.text

class CharPlusVarSel(val character: WideChar, val selector: Byte) {

    // TODO: Write tests for this
    constructor(character: Char, selector: Byte) : this(WideChar('?'), selector)

}
