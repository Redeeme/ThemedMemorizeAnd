package com.jf.themedmemorizeand.domain

import androidx.compose.ui.graphics.Color

data class EmojiGame(
    val name: String,
    val emojiSet: CardThemes,
    val numberOfPairs: Int,
    val color: Color,
    val emojiList: List<String>,
)