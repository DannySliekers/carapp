package com.example.carapp.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://10.0.2.2:4443/"
private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface CarApiService {
    @GET("car")
    suspend fun getCars(): String
}

object CarApi {
    val retrofitService : CarApiService by lazy {
        retrofit.create(CarApiService::class.java)
    }
}