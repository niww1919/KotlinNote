package com.example.kotlinnote.ui.main.note

import androidx.lifecycle.ViewModel
import com.example.kotlinnote.data.entity.Note
import com.example.kotlinnote.data.entity.NoteRepository

class NoteViewModel: ViewModel() {
    private var pandingNote: Note? = null

    fun saveNote(note: Note) {
        pandingNote = note
    }


    override fun onCleared() {
        pandingNote?.let {
            NoteRepository.saveNote(it)
        }

    }
}