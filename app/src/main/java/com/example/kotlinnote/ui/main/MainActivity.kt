package com.example.kotlinnote.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinnote.NotesRWAdapter
import com.example.kotlinnote.R
import com.example.kotlinnote.ui.main.note.NoteActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel
    lateinit var adapter: NotesRWAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        rv.layoutManager = GridLayoutManager(this, 2)



        adapter = NotesRWAdapter({ note ->
            NoteActivity.start(this,note)

        })



        rv.adapter = adapter

        viewModel.viewState().observe(this, Observer {
            it?.let { adapter.notes = it.notes }

        })

        fbt.setOnClickListener {

            NoteActivity.start(this)
        }
    }
}
