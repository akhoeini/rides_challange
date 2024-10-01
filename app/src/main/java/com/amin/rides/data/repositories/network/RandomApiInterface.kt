package com.amin.rides.data.repositories.network

import com.amin.rides.BuildConfig
import com.amin.rides.data.Vehicle
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RandomApiInterface {
    @GET("vehicle/random_vehicle")
    fun getVehicleByCount(@Query("size") size: Int): Call<List<Vehicle>>

    companion object {
        private const val BASE_URL = BuildConfig.Base_URL

        fun create(): RandomApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(RandomApiInterface::class.java)
        }
    }
}