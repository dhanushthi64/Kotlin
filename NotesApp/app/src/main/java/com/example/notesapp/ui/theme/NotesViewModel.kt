package com.example.notesapp.ui.theme

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDoa
import com.example.notesapp.data.NotesState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class NotesViewModel(
    private val dao: NoteDoa
): ViewModel() {
    private val isSortedByDateAdded : MutableStateFlow<Boolean> = MutableStateFlow(true)
    private var notes : Flow<List<Note>> =
        isSortedByDateAdded.flatMapLatest {sort ->
            if(sort){
                dao.getNotesbydateadded()
            }
            else{
                dao.getNotesbytitle()
            }
        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList() )
    val _state : MutableStateFlow<NotesState> = MutableStateFlow(NotesState())
    val state =
        combine(_state,isSortedByDateAdded,notes){state,isSortedByDateAdded,notes ->
            state.copy(
                notes = notes
            )

        }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000),NotesState())
    fun onEvent(event : NotesEvents){
        when(event){
            is NotesEvents.DeleteNote -> {
                viewModelScope.launch {
                    val notes = event.notes
                    dao.deleteNote(notes)
                }
            }
            is NotesEvents.SaveNote -> {
                val note = Note(
                    title = state.value.title.value,
                    description = state.value.description.value,
                    dateadded = System.currentTimeMillis()
                )
                viewModelScope.launch {
                    dao.upsertNote(note)
                }
                _state.update {
                    it.copy(
                        title = mutableStateOf(""),
                        description = mutableStateOf(""),
                    )
                }
            }
            is NotesEvents.UpdateNote -> {

            }
            NotesEvents.SortNotes -> {
                isSortedByDateAdded.value = !isSortedByDateAdded.value
            }


        }
    }
}