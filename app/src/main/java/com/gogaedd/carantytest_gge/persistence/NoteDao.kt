package com.gogaedd.carantytest_gge.persistence

import androidx.room.*
import com.gogaedd.carantytest_gge.model.Note

@Dao
interface NoteDao {
    @Insert

    fun insertNote(note:Note)

    @Delete
    fun deleteNote(note:Note)

    @Update
    fun updateNote(note:Note)

    @Query("Select *from Note")
    fun getNotes(): MutableList<Note>

    @Query("Select * from Note where timestamp = :timestamp")
    fun getNoteByTimestamp(timestamp: Long): Note

}