package com.jf.themedmemorizeand

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jf.themedmemorizeand.data.Card
import com.jf.themedmemorizeand.data.MemorizeGame
import com.jf.themedmemorizeand.domain.EmojiGameProvider
import com.jf.themedmemorizeand.ui.GameUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val model: MemorizeGame = MemorizeGame()
) : ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    init {
        setupNewGame()
    }

    fun setupNewGame() {
        viewModelScope.launch {
            val game = EmojiGameProvider.getRandomGame()
            model.createCards(game.emojiList)
            _uiState.update { currentState ->
                currentState.copy(
                    cards = model.cards.toList(),
                    game = game,
                    score = model.score
                )
            }
        }
    }

    fun chooseCard(card: Card) {
        viewModelScope.launch {
            model.chooseCard(card)
            _uiState.update { currentState ->
                currentState.copy(
                    cards = model.cards.toList(),
                    score = model.score
                )
            }
        }
    }
}