package com.blitzmachine.catfactsdemo.io

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.blitzmachine.catfactsdemo.io.local.CatFactDatabase
import com.blitzmachine.catfactsdemo.io.remote.CatFactApi
import com.blitzmachine.catfactsdemo.model.CatFact
import com.blitzmachine.catfactsdemo.model.CatFacts
import com.blitzmachine.catfactsdemo.utils.Utils
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import kotlin.coroutines.coroutineContext

class Repository(private val catFactApi: CatFactApi, private val catFactDatabase: CatFactDatabase) {

    val allCatFacts: LiveData<List<CatFact>> = catFactDatabase.catfactDao.getAllFacts()

    init {
        MainScope().launch(Dispatchers.IO) {
            loadAllCatFacts()
        }
    }

    suspend fun loadAllCatFacts() {
        try {
            catFactApi.httpRoutes.getAllFacts(50).also {
                MainScope().launch(Dispatchers.IO) {
                    catFactDatabase.catfactDao.deleteAllFacts()
                    catFactDatabase.catfactDao.insertFacts(it.data)
                }
            }
        } catch (ex: Exception) {
            Log.e(Utils.logTagRepository, "${ex.message}")
        }
    }
}