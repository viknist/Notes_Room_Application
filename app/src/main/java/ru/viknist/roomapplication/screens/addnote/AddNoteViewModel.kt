package ru.viknist.roomapplication.screens.addnote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.viknist.roomapplication.REPOSITROY
import ru.viknist.roomapplication.model.NoteModel

class AddNoteViewModel: ViewModel() {

    fun insert(note: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITROY.insertNote(note) {
                onSuccess
            }
        }
}