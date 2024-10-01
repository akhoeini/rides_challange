package com.amin.rides.data.repositories.local

import com.amin.rides.data.Vehicle
import com.amin.rides.data.dao.VehicleDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LocalRepo @Inject constructor(
    private val vehicleDao: VehicleDao,
) {

    //not used in this project
    fun getVehicles(): List<Vehicle> {
        return vehicleDao.getAll()
    }

    fun saveVehicles(vehicles: List<Vehicle>) {
        vehicleDao.insertAll(vehicles)
    }


}