package com.blitzmachine.catfactsdemo.io.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.blitzmachine.catfactsdemo.model.CatFact
import com.blitzmachine.catfactsdemo.utils.Utils

@Dao
interface CatFactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFacts(facts: List<CatFact>)

    @Query("SELECT * from ${Utils.tableName}")
    fun getAllFacts(): LiveData<List<CatFact>>

    @Query("DELETE from ${Utils.tableName}")
    fun deleteAllFacts()
}