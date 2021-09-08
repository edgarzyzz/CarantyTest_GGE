package com.gogaedd.carantytest_gge.model

data class Note(
    val timestamp: Long=0,
    val title: String ="",
    val isComplete: Boolean= false,
    val isActive: Boolean= false
)
