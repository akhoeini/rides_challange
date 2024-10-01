package com.amin.rides.data.wrappers

import android.util.Log
import com.amin.rides.data.Vehicle
import com.amin.rides.data.exceptions.GenericException
import com.amin.rides.data.exceptions.NetworkException
import com.amin.rides.data.repositories.local.LocalRepo
import com.amin.rides.data.repositories.network.NetworkRepo
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class VehicleDataWrapper @Inject constructor(
    private val networkRepo: NetworkRepo,
    private val localRepo: LocalRepo
) {
    private val tag = "VehicleDataWrapper"

    @Throws(NetworkException::class, GenericException::class)
    fun getVehiclesByCountAndFilter(count: Int, filter: String): List<Vehicle> {
        try {
            //loading for local repository
            var vehicles = networkRepo.fetchVehiclesByCountAndSortByFilter(count)

            //save data in db but it's above the scope of this project
            localRepo.saveVehicles(vehicles)

            //always true because i've hardcoded the filter
            if (filter == "vin"){
                vehicles=vehicles.sortedBy {
                    it.vin
                }
            }

            return vehicles
        } catch (networkException: NetworkException) {
            Log.d(tag, "a network exception occurred")
            throw networkException
        } catch (exception: Exception) {
            Log.w(tag, "an exception occurred: ${exception.message}", exception)
            throw GenericException()
        }
    }
}