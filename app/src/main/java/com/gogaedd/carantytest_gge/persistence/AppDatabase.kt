package com.gogaedd.carantytest_gge.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.gogaedd.carantytest_gge.model.Note

@Database(entities = arrayOf(Note::class), version = 1)
abstract class AppDatabase() : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase{
            if (INSTANCE== null){
                INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java,"App.db").build()
            }
            return INSTANCE!!
        }

    }


}