package com.gogaedd.carantytest_gge.repository

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.gogaedd.carantytest_gge.model.Note
import com.gogaedd.carantytest_gge.persistence.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking

class MainRepository(private val application: Application) {
    private val db =  AppDatabase.getDatabase(application)
    private val noteDao = db.noteDao()


    private val mLvdNotes = MutableLiveData<MutableList<Note>>(mutableListOf())
    fun getLvdNote() = mLvdNotes


    fun loadAllNotes(){
        runBlocking(Dispatchers.IO) {
            mLvdNotes.postValue(noteDao.getNotes())
        }
    }


    fun addNote(note:Note){
        runBlocking (Dispatchers.IO){
            noteDao.insertNote(note)
        }
    }

    fun deleteNote(note:Note){
        runBlocking (Dispatchers.IO){
            noteDao.deleteNote(note)
        }
    }

    fun updateNote(note:Note){
        runBlocking (Dispatchers.IO){
            noteDao.updateNote(note)
        }
    }




}