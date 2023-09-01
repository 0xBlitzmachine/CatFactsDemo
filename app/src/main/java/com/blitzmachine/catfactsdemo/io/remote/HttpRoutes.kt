package com.blitzmachine.catfactsdemo.io.remote

import com.blitzmachine.catfactsdemo.model.CatFact
import com.blitzmachine.catfactsdemo.model.CatFacts
import retrofit2.http.GET

interface HttpRoutes {

    @GET("fact")
    suspend fun getRandomFact(): CatFact

    @GET("facts")
    suspend fun getRandomFacts(): CatFacts
}