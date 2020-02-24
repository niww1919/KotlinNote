package com.example.kotlinnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnote.data.entity.Note
import com.example.kotlinnote.data.entity.Note.Color.*
import kotlinx.android.synthetic.main.item_note.view.*

class NotesRWAdapter (val onItemViewClick: ((note:Note) -> Unit)? = null) : RecyclerView.Adapter<NotesRWAdapter.ViewHolder>() {

    var notes: List<Note> = listOf()
    set(value) {
        field = value
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)

    )

    override fun getItemCount() = notes.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(notes[position])

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


        fun bind(note: Note) {
            itemView.tv_title.text = note.title
            itemView.tv_text.text = note.text

            val color = when (note.color) {
                WHITE ->R.color.white
                YELLOW ->R.color.yellow
                GREEN ->R.color.green
                BLUE ->R.color.blue
                RED ->R.color.red
                VIOLET ->R.color.violet
            }


            (this as CardView).setCardBackgroundColor(ContextCompat.getColor(itemView.context,color))

            itemView.setOnClickListener {
                onItemViewClick?.invoke(note)
            }


        }

    }

}