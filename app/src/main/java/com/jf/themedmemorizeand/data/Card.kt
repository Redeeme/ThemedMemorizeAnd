package com.jf.themedmemorizeand.data

data class Card(
    var isFaceUp:Boolean = false,
    var isMatched: Boolean = false,
    val content: String,
    val id: String
)
