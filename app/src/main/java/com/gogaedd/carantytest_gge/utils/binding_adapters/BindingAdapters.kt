package com.gogaedd.carantytest_gge.utils.binding_adapters

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gogaedd.carantytest_gge.adapters.NoteAdapter
import com.gogaedd.carantytest_gge.model.Note

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("setDataNotes")
    fun setDataNotes(rv:RecyclerView, listNotes: MutableList<Note>){
        rv.adapter?.let{adapterNotNull->
            if (adapterNotNull is NoteAdapter){
                adapterNotNull.updateElements(listNotes)
            }
        }

    }


}