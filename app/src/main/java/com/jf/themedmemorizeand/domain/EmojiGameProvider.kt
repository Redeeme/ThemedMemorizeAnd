package com.jf.themedmemorizeand.domain

import androidx.compose.ui.graphics.Color

object EmojiGameProvider {

    fun getRandomGame(): EmojiGame {
        return when(CardThemes.entries.toTypedArray().random()) {
            CardThemes.SMILE_EMOJI -> getSmileGame()
            CardThemes.SAD_EMOJI -> getSadGame()
            CardThemes.SCARY_EMOJI -> getScaryGame()
            CardThemes.ANIMAL_EMOJI -> getAnimalGame()
            CardThemes.FEMALE_EMOJI -> getFemaleGame()
            CardThemes.MALE_EMOJI -> getMaleGame()
        }
    }

    fun getSmileGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.SMILE_EMOJI.toString(),
            emojiSet = CardThemes.SMILE_EMOJI,
            numberOfPairs = 7,
            color = Color.Red,
            emojiList = listOf(
                "\uD83D\uDE0A", // 😊
                "\uD83D\uDE04", // 😄
                "\uD83D\uDE01", // 😁
                "\uD83D\uDE03", // 😃
                "\uD83D\uDE02", // 😂
                "\uD83E\uDD23", // 🤣
                "\uD83D\uDE0B", // 😋
                "\uD83D\uDE0E"  // 😎
            )
        )
    }

    fun getSadGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.SAD_EMOJI.toString(),
            emojiSet = CardThemes.SAD_EMOJI,
            numberOfPairs = 7,
            color = Color.Blue,
            emojiList = listOf(
                "\uD83D\uDE1E", // 😞
                "\uD83D\uDE22", // 😢
                "\uD83D\uDE2D", // 😭
                "\uD83D\uDE14", // 😔
                "\uD83D\uDE1F", // 😟
                "\uD83E\uDD72", // 🥺
                "\uD83D\uDE25", // 😥
                "\uD83D\uDE13"  // 😓
            )
        )
    }

    fun getScaryGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.SCARY_EMOJI.toString(),
            emojiSet = CardThemes.SCARY_EMOJI,
            numberOfPairs = 7,
            color = Color.Black,
            emojiList = listOf(
                "\uD83D\uDC7B", // 👻
                "\uD83D\uDC80", // 💀
                "\uD83D\uDC7F", // 👿
                "\uD83D\uDC79", // 👹
                "\uD83D\uDE31", // 😱
                "\uD83E\uDD21", // 🤡
                "\uD83D\uDC7A", // 👺
                "☠️"           // ☠️
            )
        )
    }

    fun getAnimalGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.ANIMAL_EMOJI.toString(),
            emojiSet = CardThemes.ANIMAL_EMOJI,
            numberOfPairs = 7,
            color = Color.Green,
            emojiList = listOf(
                "\uD83D\uDC31", // 🐱
                "\uD83D\uDC36", // 🐶
                "\uD83D\uDC3C", // 🐼
                "\uD83E\uDD81", // 🦁
                "\uD83D\uDC2F", // 🐯
                "\uD83D\uDC28", // 🐨
                "\uD83D\uDC30", // 🐰
                "\uD83E\uDD8A"  // 🦊
            )
        )
    }

    fun getFemaleGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.FEMALE_EMOJI.toString(),
            emojiSet = CardThemes.FEMALE_EMOJI,
            numberOfPairs = 7,
            color = Color.Magenta,
            emojiList = listOf(
                "\uD83D\uDC69", // 👩
                "\uD83D\uDC71\u200D♀️", // 👱‍♀️
                "\uD83D\uDC78", // 👸
                "\uD83E\uDDD9\u200D♀️", // 🧝‍♀️
                "\uD83E\uDDDC\u200D♀️", // 🧜‍♀️
                "\uD83D\uDC70\u200D♀️", // 👰‍♀️
                "\uD83E\uDD30", // 🤰
                "\uD83D\uDC69\u200D\uD83E\uDDB0" // 👩‍🦰
            )
        )
    }

    fun getMaleGame(): EmojiGame {
        return EmojiGame(
            name = CardThemes.MALE_EMOJI.toString(),
            emojiSet = CardThemes.MALE_EMOJI,
            numberOfPairs = 7,
            color = Color.Blue,
            emojiList = listOf(
                "\uD83D\uDC68", // 👨
                "\uD83D\uDC71\u200D♂️", // 👱‍♂️
                "\uD83E\uDD34", // 🤴
                "\uD83E\uDDD9\u200D♂️", // 🧝‍♂️
                "\uD83E\uDDDC\u200D♂️", // 🧜‍♂️
                "\uD83D\uDC70\u200D♂️", // 👰‍♂️
                "\uD83E\uDDD4", // 🧔
                "\uD83D\uDC68\u200D\uD83E\uDDB0" // 👨‍🦰
            )
        )
    }
}
