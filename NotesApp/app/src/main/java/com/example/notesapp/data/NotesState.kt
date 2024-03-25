package com.example.notesapp.data

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class NotesState(
    val notes : List<Note> = emptyList(),
    val title : MutableState<String> = mutableStateOf(""),
    val description : MutableState<String> = mutableStateOf("")
)
