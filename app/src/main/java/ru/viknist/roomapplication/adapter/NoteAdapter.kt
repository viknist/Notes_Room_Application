package ru.viknist.roomapplication.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.viknist.roomapplication.R
import ru.viknist.roomapplication.model.NoteModel

class NoteAdapter(
    var noteList: List<NoteModel>,
    private val clickListener: (position: Int) -> Unit
) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    override fun getItemCount(): Int = noteList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false),
            clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): NoteModel = noteList[position]

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        noteList = list
        notifyDataSetChanged()
    }

    class ViewHolder(
        itemView: View,
        listener: (position: Int) -> Unit
    ) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.item_title)

        init {
            itemView.setOnClickListener {
                val position = absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener(position)
                }
            }
        }

        fun bind(note: NoteModel) {
            title.text = note.title
        }
    }
}