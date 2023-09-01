package com.blitzmachine.catfactsdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class CatFact(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fact: String,
    val length: Int
)