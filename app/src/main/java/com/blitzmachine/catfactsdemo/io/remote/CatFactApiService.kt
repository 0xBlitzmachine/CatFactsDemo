package com.blitzmachine.catfactsdemo.io.remote

import com.blitzmachine.catfactsdemo.utils.Utils
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retroFit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(Utils.baseUrl)
    .build()

object CatFactApi {
    val httpRoutes: HttpRoutes by lazy { retroFit.create(HttpRoutes::class.java) }
}