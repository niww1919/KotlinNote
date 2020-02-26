package com.example.kotlinnote.ui.main.note

import android.content.Context
import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinnote.R
import com.example.kotlinnote.data.entity.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_note.*
import java.util.*

class NoteActivity: AppCompatActivity(){

    companion object{
        private val EXTRA_NOTE = NoteActivity::class.java.name + "extra.NOTE"
        private const val DATA_TIME_FORMAT = "dd.MM.yy HH:mm"
        private const val SAVA_DELAY = 2000L


        fun start(context: Context, note: Note?  = null) {

            val intent = Intent(context, NoteActivity::class.java)
            intent.putExtra(EXTRA_NOTE,note)
            context.startActivity(intent)
        }
    }

    private var note: Note? = null
    lateinit var viewModel: NoteViewModel

    val textChangeListener = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            saveNote()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note)

        note = intent.getParcelableExtra(EXTRA_NOTE)
        setSupportActionBar(toolbar)
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)


        viewModel = ViewModelProvider(this).get(NoteViewModel::class.java)


        supportActionBar?.title = note?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                SimpleDateFormat(DATA_TIME_FORMAT, Locale.getDefault()).format(it.lastChanged)
            } else {
                "Note"
            }
        } ?: let {
            "New note"
        }
        initView()
    }

    private fun initView() {
        note?.let {note ->
            et_title.setText(note.title)
            et_body.setText(note.text)

            val color = when (note.color) {
            Note.Color.WHITE ->R.color.white
            Note.Color.YELLOW ->R.color.yellow
            Note.Color.GREEN ->R.color.green
            Note.Color.BLUE ->R.color.blue
            Note.Color.RED ->R.color.red
            Note.Color.VIOLET ->R.color.violet
        }
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                toolBar.setBackgroundColor(resources.getColor(color, null))
//            }


            et_title.addTextChangedListener(textChangeListener)
            et_body.addTextChangedListener(textChangeListener)
        }




    }

    fun saveNote() {
        if (et_title.text == null || et_title.text!!.length <3 ) return

        Handler().postDelayed({
            note = note?.copy(
                title = et_title.text.toString(),
                text = et_body.text.toString(),
                lastChanged = Date()

            ) ?: createNewNote()

            note?.let { viewModel.saveNote(it) }
        }, SAVA_DELAY)
    }
    private fun createNewNote() :Note = Note(UUID.randomUUID().toString(), et_title.text.toString(),et_body.text.toString())

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home ->{
            onBackPressed()
            true}

        else-> super.onOptionsItemSelected(item)
    }
}