package com.jf.themedmemorizeand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jf.themedmemorizeand.ui.EmojiGameView
import com.jf.themedmemorizeand.ui.theme.ThemedMemorizeAndTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            ThemedMemorizeAndTheme {

                val state = viewModel.uiState.collectAsStateWithLifecycle()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar({state.value.game?.name?.let { Text(it) }},
                            actions = {
                                Text("Score: ${state.value.score}")
                            })
                    }) { innerPadding ->
                    EmojiGameView(
                        modifier = Modifier.padding(innerPadding),
                        state = state.value,
                        onReset = {
                            viewModel.setupNewGame()
                        },
                        onCard = {
                            viewModel.chooseCard(it)
                        }
                    )
                }

            }
        }
    }
}

