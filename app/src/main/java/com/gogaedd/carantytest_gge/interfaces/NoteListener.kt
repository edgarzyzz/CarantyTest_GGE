package com.gogaedd.carantytest_gge.interfaces

import com.gogaedd.carantytest_gge.model.Note

interface NoteListener {
    fun onEditNote(note:Note)
    fun onDeleteNote(note: Note)
}