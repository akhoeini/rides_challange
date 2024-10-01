package com.amin.rides.data.repositories.network

import android.util.Log
import com.amin.rides.data.Vehicle
import com.amin.rides.data.exceptions.GenericException
import com.amin.rides.data.exceptions.NetworkException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkRepo @Inject constructor() {
    private val tag = "NetworkRepo"

    fun fetchVehiclesByCountAndSortByFilter(count:Int):List<Vehicle>{
        val apiInterface = RandomApiInterface.create()
        val request =
            apiInterface.getVehicleByCount(count)


        val response = request.execute()

        if (!response.isSuccessful) {
            Log.w(
                tag,
                "a network error occurred, throwing a NetworkException ${response.errorBody()}"
            )
            throw NetworkException()
        }

        val responseBody = response.body()
        if (responseBody == null) {
            Log.w(
                tag,
                "an unexpected error occurred, throwing a GenericException ${response.errorBody()}"
            )
            throw GenericException()
        }

        Log.d(tag, "response body: $responseBody")

        return responseBody
    }
}