package ru.viknist.roomapplication.db.repository

import androidx.lifecycle.LiveData
import ru.viknist.roomapplication.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>

    suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit)
}