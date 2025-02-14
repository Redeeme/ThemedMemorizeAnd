package com.jf.themedmemorizeand.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.TextAutoSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jf.themedmemorizeand.data.Card
import com.jf.themedmemorizeand.ui.theme.ThemedMemorizeAndTheme

@Composable
fun EmojiGameView(
    modifier: Modifier = Modifier,
    state: GameUiState,
    onReset: () -> Unit = {},
    onCard: (Card) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 110.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(state.cards, key = { it.id }) { card ->
                    state.game?.color?.let {
                        CardView(
                            Modifier.clickable { onCard(card) },
                            card,
                            it
                        )
                    }
                }
            }
        }

        Button(
            onClick = { onReset() },
            modifier = Modifier.padding(vertical = 16.dp)
        ) {
            Text("New Game")
        }
    }


}

@Composable
fun CardView(modifier: Modifier, card: Card, color: Color) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .padding(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White, shape = RoundedCornerShape(8.dp))
                .border(width = 2.dp, color = color, shape = RoundedCornerShape(8.dp))
        )
        BasicText(
            text = card.content,
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            modifier = Modifier.padding(4.dp),
            autoSize = TextAutoSize.StepBased(
                minFontSize = 10.sp,
                maxFontSize = 100.sp,
                stepSize = 10.sp
            )
        )
        if (!card.isFaceUp) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = color, shape = RoundedCornerShape(8.dp))
            )
        }

        if (card.isMatched) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.White, shape = RoundedCornerShape(8.dp))
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ThemedMemorizeAndTheme {
        EmojiGameView(
            state = GameUiState()
        )
    }
}