package com.blitzmachine.catfactsdemo.io.remote

import androidx.lifecycle.LiveData
import com.blitzmachine.catfactsdemo.model.CatFact
import com.blitzmachine.catfactsdemo.model.CatFacts
import retrofit2.http.GET
import retrofit2.http.Query

interface HttpRoutes {

    @GET("fact")
    suspend fun getRandomFact(): CatFact

    @GET("facts?")
    suspend fun getAllFacts(@Query("limit")limit: Int): CatFacts
}