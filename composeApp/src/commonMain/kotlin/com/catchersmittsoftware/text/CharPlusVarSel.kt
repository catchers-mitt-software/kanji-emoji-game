package com.catchersmittsoftware.text

class CharPlusVarSel(val character: WideChar, val selector: Byte) {

    override fun toString(): String {
        return character.toString() + (65024 + selector).toChar()
    }

    constructor(character: Char, selector: Byte) :
            this(WideChar(character), selector)

}
