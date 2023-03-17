package ru.viknist.roomapplication.screens.start

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import ru.viknist.roomapplication.REPOSITROY
import ru.viknist.roomapplication.db.NoteDatabase
import ru.viknist.roomapplication.db.repository.NoteRealisation
import ru.viknist.roomapplication.model.NoteModel

class StartViewModel(application: Application) : AndroidViewModel(application) {

    val context = application

    fun initDatabase() {
        val daoNote = NoteDatabase.getInstance(context).getNoteDao()
        REPOSITROY = NoteRealisation(daoNote)
    }

    fun getAllNotes(): LiveData<List<NoteModel>> {
        return REPOSITROY.allNotes
    }


}