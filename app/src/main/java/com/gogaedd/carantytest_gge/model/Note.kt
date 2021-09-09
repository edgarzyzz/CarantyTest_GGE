package com.gogaedd.carantytest_gge.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Note(
    @PrimaryKey
    val timestamp: Long=0,
    val title: String ="",
    val message: String ="",
    var isComplete: Boolean= false,
    val isActive: Boolean= false
): Serializable
