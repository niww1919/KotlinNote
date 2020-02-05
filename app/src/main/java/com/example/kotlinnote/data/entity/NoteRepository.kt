package com.example.kotlinnote.data.entity

object NoteRepository {

    private val notes: List<Note>

    init {
        notes = listOf(
            Note("Заголово 1",
                "Текст заметки 1",
                0xfffe8eaf6.toInt()

            ),
            Note("Заголово 2",
                "Текст заметки 2",
                0xfffe8eaf6.toInt()

            ),
            Note("Заголово 3",
                "Текст заметки 3",
                0xfffe8eaf6.toInt()

            ),
            Note("Заголово 4",
                "Текст заметки 4",
                0xfffe8eaf6.toInt()

            ),
            Note("Заголово 5",
                "Текст заметки 5",
                0xfffe8eaf6.toInt()

            ),
            Note("Заголово 6",
                "Текст заметки 6",
                0xfffe8eaf6.toInt()
            )
        )
    }

    fun getNotes(): List<Note> {
        return notes
    }
}