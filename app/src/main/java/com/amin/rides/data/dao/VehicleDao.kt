package com.amin.rides.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.amin.rides.data.Vehicle

@Dao
interface VehicleDao {

    @Query("SELECT * FROM vehicle order by vin asc")
    fun getAll(): List<Vehicle>

    @Query("SELECT * FROM vehicle WHERE uid = :uuid LIMIT 1")
    fun findByUUID(uuid: String): Vehicle

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vehicle: Vehicle)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vehicles: Collection<Vehicle>)


    @Delete
    fun delete(vehicle: Vehicle)
}