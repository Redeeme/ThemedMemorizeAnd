package com.jf.themedmemorizeand.data

class MemorizeGame {
    private val _cards: MutableList<Card> = mutableListOf()
    val cards: List<Card> get() = _cards.toList()

    var score: Int = 0

    fun createCards(content: List<String>){
        _cards.clear()
        score = 0
        content.forEachIndexed{ index,it->
            _cards.add(
                Card(
                    content = it,
                    id = "$index a"
                )
            )
            _cards.add(
                Card(
                    content = it,
                    id = "$index b"
                )
            )
        }
        _cards.shuffle()
    }

    fun chooseCard(card: Card) {
        val index = _cards.indexOfFirst { it.id == card.id }
        if (index != -1 && !_cards[index].isMatched) {
            _cards[index] = _cards[index].copy(isFaceUp = !_cards[index].isFaceUp)
        }
        checkMatch()
        checkScore()
    }

    private fun checkMatch(){
        val cardsFaceUp = cards.filter { it.isFaceUp }
        if (cardsFaceUp.count() == 3){
            if (cardsFaceUp[0].content == cardsFaceUp[1].content){
                cards[cards.indexOf(cardsFaceUp[0])].isMatched = true
                cards[cards.indexOf(cardsFaceUp[1])].isMatched = true
            }
            cards.forEach{ it.isFaceUp = false }
        }
        if (cards.count { !it.isMatched } == 2){
            if (cardsFaceUp.count() == 2){
                cards[cards.indexOf(cardsFaceUp[0])].isMatched = true
                cards[cards.indexOf(cardsFaceUp[1])].isMatched = true
            }
        }
    }

    private fun checkScore(){
        val cardsMatches = cards.filter { it.isMatched }
        if (cardsMatches.isNotEmpty()){
            score = cardsMatches.count() / 2
        }
    }
}