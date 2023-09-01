package com.blitzmachine.catfactsdemo.io

import com.blitzmachine.catfactsdemo.io.local.CatFactDatabase
import com.blitzmachine.catfactsdemo.io.remote.CatFactApi

class Repository(private val catFactApi: CatFactApi, private val catFactDatabase: CatFactDatabase) {
}