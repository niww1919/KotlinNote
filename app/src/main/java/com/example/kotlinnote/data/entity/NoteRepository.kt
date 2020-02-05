package com.example.kotlinnote.data.entity

object NoteRepository {

    private val notes: List<Note>

    init {
        notes = listOf(
            Note("Заголово 1",
                "Текст заметки 1",
                0xfff6002ee.toInt()

            ),
            Note("Заголово 2",
                "Текст заметки 2",
                0xfff6002ee.toInt()

            ),
            Note("Заголово 3",
                "Текст заметки 3",
                0xfff6002ee.toInt()

            ),
            Note("Заголово 4",
                "Текст заметки 4",
                0xfff6002ee.toInt()

            ),
            Note("Заголово 5",
                "Текст заметки 5",
                0xfff6002ee.toInt()

            ),
            Note("Заголово 6",
                "Текст заметки 6",
                0xfff6002ee.toInt()
            )
        )
    }

    fun getNotes(): List<Note> {
        return notes
    }
}