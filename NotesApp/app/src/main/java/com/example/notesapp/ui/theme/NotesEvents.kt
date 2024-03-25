package com.example.notesapp.ui.theme

import com.example.notesapp.data.Note

sealed interface NotesEvents {
    object SortNotes : NotesEvents
    data class DeleteNote(val notes: Note) : NotesEvents
    data class SaveNote(
        val title: String,
        val description : String
    ) : NotesEvents
    data class UpdateNote(
        val title: String,
        val description : String
    ) : NotesEvents
}