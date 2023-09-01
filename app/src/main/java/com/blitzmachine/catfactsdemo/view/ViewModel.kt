package com.blitzmachine.catfactsdemo.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.blitzmachine.catfactsdemo.io.Repository
import com.blitzmachine.catfactsdemo.io.local.CatFactDatabase
import com.blitzmachine.catfactsdemo.io.local.getDatabase
import com.blitzmachine.catfactsdemo.io.remote.CatFactApi

class ViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)
    private val repository = Repository(CatFactApi, database)
}