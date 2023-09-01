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
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class Repository(private val catFactApi: CatFactApi, private val catFactDatabase: CatFactDatabase) {

    private val _randomCatFact: MutableLiveData<CatFact> = MutableLiveData()
    val randomCatFact: LiveData<CatFact> get() = _randomCatFact

    private val _listOfCatFacts: MutableLiveData<List<CatFact>> = MutableLiveData()
    val listOfCatFacts: LiveData<List<CatFact>> get() = _listOfCatFacts


    suspend fun getRandomCatFact() {
        try {
            _randomCatFact.postValue(catFactApi.httpRoutes.getRandomFact())
        } catch (ex: Exception) {
            Log.e(Utils.logTagRepository, ex.message!!)
        }
    }

    suspend fun getListOfCatFacts() {
        try {
            _listOfCatFacts.postValue(catFactApi.httpRoutes.getAllFacts().data)
        } catch (ex: Exception) {
            Log.e(Utils.logTagRepository, ex.message!!)
        }
    }
}