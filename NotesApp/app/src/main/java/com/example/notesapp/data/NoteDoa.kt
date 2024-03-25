package com.example.notesapp.data

import android.provider.ContactsContract
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDoa {

    @Upsert
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY dateadded")
    fun getNotesbydateadded(): Flow<List<Note>>

    @Query("SELECT * FROM note ORDER BY title ASC")
    fun getNotesbytitle(): Flow<List<Note>>

}