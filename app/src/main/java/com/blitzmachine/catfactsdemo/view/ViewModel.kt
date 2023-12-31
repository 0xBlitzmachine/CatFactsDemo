package com.blitzmachine.catfactsdemo.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.blitzmachine.catfactsdemo.io.Repository
import com.blitzmachine.catfactsdemo.io.local.getDatabase
import com.blitzmachine.catfactsdemo.io.remote.CatFactApi
import com.blitzmachine.catfactsdemo.model.CatFact
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(CatFactApi, database)

    val allCatFacts: LiveData<List<CatFact>> = repository.allCatFacts

    fun loadCatFacts() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.loadAllCatFacts()
        }
    }
}