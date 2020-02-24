package com.example.kotlinnote

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinnote.data.entity.NoteRealm
import com.example.kotlinnote.data.entity.ParentModel
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.parent_rv.view.*

class ParentAdapter(private val parents: List<ParentModel>) : RecyclerView.Adapter<ParentAdapter.ViewHolder>() {



    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.parent_rv, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val parent = parents[position]
        holder.textView.text = parent.title
        holder.btn.text ="btn"

        val childLayoutManager = LinearLayoutManager(
            holder.recyclerView.context,
            RecyclerView.VERTICAL,
            false
        )
//        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.children)
            setRecycledViewPool(viewPool)

            val itemTouch = ItemTouchHelper(object :
                ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {

                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    if (direction == ItemTouchHelper.LEFT) {
                        //todo add realm

//                        realm.executeTransaction { realm ->
//                            val myNote = realm.createObject<NoteRealm>()
//                            myNote.myNote = "Test"
//
//                            Toast.makeText(
//                                this,
//                                realm.where<NoteRealm>().findAll().asJSON(),
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        }


                    }
                    if (direction == ItemTouchHelper.RIGHT) {
                    }

                }

            })
//        itemTouch.attachToRecyclerView(rv_parent)
            itemTouch.attachToRecyclerView(holder.recyclerView)


        }

    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.tv_title
        val btn: AppCompatButton = itemView.btn_add_item
    }
}