package com.gogaedd.carantytest_gge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gogaedd.carantytest_gge.model.Note
import com.gogaedd.carantytest_gge.repository.MainRepository

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: MainRepository = MainRepository(application)

    //Lvd
    private val lvdNotes = repository.getLvdNote()

    //Getters LVD
    fun getLvdNotes() = lvdNotes

    //Repository Methods
    fun loadAllNotes() = repository.loadAllNotes()
    fun addNote(note: Note) = repository.addNote(note)
    fun deleteNote(note: Note) = repository.deleteNote(note)
    fun updateNote(note: Note) = repository.updateNote(note)

    fun createNote(title: String, message: String) {
        val noteCreated = Note(
            System.currentTimeMillis(),
            title,
            message,
            isComplete = false,
            isActive = true
        )
        repository.addNote(noteCreated)


    }


}