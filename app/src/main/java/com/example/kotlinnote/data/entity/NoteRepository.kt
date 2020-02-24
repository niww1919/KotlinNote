package com.example.kotlinnote.data.entity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

object NoteRepository {

    private val noteLiveData = MutableLiveData<List<Note>>()

    private val notes: MutableList<Note> = mutableListOf(
            Note(
                UUID.randomUUID().toString(),
                "Заголово 1",
                "Текст заметки 1",
                Note.Color.VIOLET

            ),
            Note(
                UUID.randomUUID().toString(),
                "Заголово 2",
                "Текст заметки 2",

                Note.Color.RED
            ),
            Note(
                UUID.randomUUID().toString(),

                "Заголово 3",
                "Текст заметки 3",

                Note.Color.GREEN
            ),
            Note(
                UUID.randomUUID().toString(),

                "Заголово 4",
                "Текст заметки 4",
                Note.Color.BLUE

            ),
            Note(
                UUID.randomUUID().toString(),

                "Заголово 5",
                "Текст заметки 5",

                Note.Color.WHITE
            ),
            Note(
                UUID.randomUUID().toString(),

                "Заголово 6",
                "Текст заметки 6",
                Note.Color.YELLOW
            )

        )

    init {
        noteLiveData.value = notes
    }

    fun saveNote(note: Note) {
    addOrReplace(note)
        noteLiveData.value = notes

    }

    private fun addOrReplace(note: Note) {
        for (i in notes.indices) {
            if (notes[i] == note) {
                notes[i] = note
                return
            }

        }
        notes.add(note)
    }

    fun getNotes(): LiveData <List<Note>> {
        return noteLiveData
    }
}