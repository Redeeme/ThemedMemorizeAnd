package com.jf.themedmemorizeand.ui

import com.jf.themedmemorizeand.data.Card
import com.jf.themedmemorizeand.domain.EmojiGame

data class GameUiState(
    val cards: List<Card> = emptyList(),
    val game: EmojiGame? = null,
    val score: Int = 0,
)