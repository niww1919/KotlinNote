package com.example.kotlinnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnote.data.entity.Note
import com.example.kotlinnote.data.entity.NoteRealm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.item_note.view.*

class NestedNotesRWAdapter : RecyclerView.Adapter<NestedNotesRWAdapter.ViewHolder>() {


    var notes: List<Note> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

//    var realmResults:RealmResults<NoteRealm> =


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)

    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(notes[position])
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(note: Note) {
//            itemView.tv_title.text = note.title
//            itemView.tv_text.text = note.text
            itemView.setBackgroundColor(note.color)

            itemView.setOnClickListener { v: View? -> v?.setBackgroundColor(0xfffe3f356.toInt()) }

        }

    }

}