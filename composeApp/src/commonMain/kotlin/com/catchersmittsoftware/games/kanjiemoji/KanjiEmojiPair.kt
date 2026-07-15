package com.catchersmittsoftware.games.kanjiemoji

import com.catchersmittsoftware.text.WideChar

/**
 * Holds a pair of a kanji from the Basic Multilingual Plane (BMP) and an emoji
 * that may be from any plane.
 * @param kanji A character from the BMP, preferably from the CJK Unified
 * Ideographs block, but this is not enforced. For example, '&#x5C71;'.
 * @param emoji A character from any plane, preferably from a symbols and
 * pictographs block in the Supplementary Multilingual Plane, but this is not
 * enforced. For example, '&#x26F0;&#xFE0F;'.
 */
data class KanjiEmojiPair(val kanji: Char, val emoji: WideChar)
