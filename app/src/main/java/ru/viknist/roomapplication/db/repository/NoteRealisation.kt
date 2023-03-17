package ru.viknist.roomapplication.db.repository

import androidx.lifecycle.LiveData
import ru.viknist.roomapplication.db.dao.NoteDao
import ru.viknist.roomapplication.model.NoteModel

class NoteRealisation(private val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(note)
        onSuccess()
    }

    override suspend fun deleteNote(note: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(note)
        onSuccess()
    }

}