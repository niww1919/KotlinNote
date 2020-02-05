package com.example.kotlinnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.GridLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel:MainViewModel
    lateinit var adapter: NotesRWAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        rv.layoutManager = GridLayoutManager(this, 1)
        adapter = NotesRWAdapter()
        rv.adapter = adapter

        viewModel.viewState().observe(this, Observer {
            it?.let { adapter.notes = it.notes }

        })
    }
}
