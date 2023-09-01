package com.blitzmachine.catfactsdemo.io.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.blitzmachine.catfactsdemo.model.CatFact

@Dao
interface CatFactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFact(fact: CatFact)
}