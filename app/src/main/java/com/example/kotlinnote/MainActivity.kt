package com.example.kotlinnote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnote.data.entity.NoteRealm
import com.example.kotlinnote.data.entity.ParentDataFactory
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var realm:Realm
    lateinit var viewModel: MainViewModel
//    lateinit var adapter: NotesRWAdapter

    lateinit var recyclerView: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Realm.init(this)
        val config = RealmConfiguration.Builder()
            .name("BD")
            .schemaVersion(1)
            .build()
        realm = Realm.getInstance(config)

        initRecycler()


//        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
//
//        rv_parent.layoutManager = GridLayoutManager(this, 1)
//        adapter = NotesRWAdapter()
//        rv_parent.adapter = adapter





    }

    private fun initRecycler() {
        recyclerView = rv_parent

        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL, false)
            adapter = ParentAdapter(
                ParentDataFactory
                .getParents(5))
        }
    }

}
