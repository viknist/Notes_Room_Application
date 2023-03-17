package ru.viknist.roomapplication.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.viknist.roomapplication.REPOSITROY
import ru.viknist.roomapplication.model.NoteModel

class DetailViewModel : ViewModel() {

    fun delete(note: NoteModel, onSuccess: () -> Unit) =
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITROY.deleteNote(note) {
                onSuccess
            }
        }

}