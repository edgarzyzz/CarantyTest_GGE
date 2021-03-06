package com.gogaedd.carantytest_gge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.carantytest_gge.databinding.ItemNoteBinding
import com.gogaedd.carantytest_gge.interfaces.NoteListener
import com.gogaedd.carantytest_gge.model.Note

class NoteAdapter() : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    private val mListNotes: MutableList<Note> = mutableListOf()

    private var mListener: NoteListener? = null


    fun setListener(listener: NoteListener) {
        mListener = listener

    }

    fun updateElements(updatedlist: MutableList<Note>) {
        mListNotes.clear()
        mListNotes.addAll(updatedlist)
        notifyDataSetChanged()

    }

    fun removeItem(position: Int) {

        mListNotes.removeAt(position)
        notifyItemRemoved(position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemNoteBinding.inflate(inflater, parent, false)
        return NoteViewHolder(binding,mListener)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) =
        holder.bind(mListNotes[position])

    override fun getItemCount(): Int = mListNotes.size

    class NoteViewHolder(private val binding: ItemNoteBinding, val mlistener: NoteListener?) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.apply {
                this.note = note
                ibtnDeleteItmn.setOnClickListener { mlistener?.onDeleteNote(note,adapterPosition) }
                cbCompleteItmn.setOnCheckedChangeListener { compoundButton, isChecked ->
                    note.isComplete = isChecked
                    mlistener?.onNoteChanged(note)
                }
                root.setOnClickListener {
                    mlistener?.onEditNote(note)
                }
            }


        }

    }
}