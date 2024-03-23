package com.example.unscramble.data


const val MAX_NO_OF_WORDS = 10
const val SCORE_INCREASE = 20

// Set with all the words for the Game
val allWords: Set<String> =
    setOf(
        "animal",
        "auto",
        "anecdote",
        "alphabet",
        "all",
        "awesome",
        "arise",
        "balloon",
        "basket",
        "bench",
        // ...
        "zoology",
        "zone",
        "zeal"
    )
private val wordLengthMap: Map<Int, String> = allWords.associateBy({ it.length }, { it })
internal fun getUnscrambledWord(scrambledWord: String) = wordLengthMap[scrambledWord.length] ?: ""