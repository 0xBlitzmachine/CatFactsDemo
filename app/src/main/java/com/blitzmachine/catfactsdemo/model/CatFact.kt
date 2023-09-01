package com.blitzmachine.catfactsdemo.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.blitzmachine.catfactsdemo.utils.Utils


@Entity(tableName = Utils.tableName)
data class CatFact(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val fact: String
)