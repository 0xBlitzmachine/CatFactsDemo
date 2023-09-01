package com.blitzmachine.catfactsdemo.io.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.blitzmachine.catfactsdemo.model.CatFact
import com.blitzmachine.catfactsdemo.utils.Utils

private lateinit var INSTANCE: CatFactDatabase

@Database(entities = [CatFact::class], version = 1)
abstract class CatFactDatabase : RoomDatabase(){
    abstract val catfactDao: CatFactDao
}

fun getDatabase(context: Context): CatFactDatabase {
    synchronized(CatFactDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CatFactDatabase::class.java,
                Utils.tableName
            ).build()
        }
        return INSTANCE
    }
}