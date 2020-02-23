package com.example.kotlinnote

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnote.data.entity.NoteRealm
import com.example.kotlinnote.data.entity.ParentDataFactory
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.parent_rv.*

class MainActivity : AppCompatActivity() {

    lateinit var realm:Realm
    lateinit var viewModel: MainViewModel
    lateinit var note:NoteRealm

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

        val botton =findViewById<View>(R.id.btn_add_item)
        botton?.setOnClickListener {
            Toast.makeText(baseContext , "Done", Toast.LENGTH_SHORT).show()

        }

//        btn_add_item.setOnClickListener {
//            View.OnClickListener {
//                realm.executeTransaction {
//                    note = realm.createObject(NoteRealm::class.java)
//                    note.myNote = "DFdf"
//
//                    Log.i("realmList", " " + note)
//
//                }
//            }
//        }


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

