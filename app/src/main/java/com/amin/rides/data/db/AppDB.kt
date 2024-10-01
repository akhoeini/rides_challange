package com.amin.rides.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.amin.rides.data.Vehicle
import com.amin.rides.data.dao.VehicleDao
import com.amin.rides.utils.Converters

@Database(entities = [Vehicle::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDB : RoomDatabase() {

    abstract fun vehicleDao(): VehicleDao

    companion object {

        private const val DB_NAME = "rides-db"

        @Volatile
        private var instance: AppDB? = null

        fun getInstance(context: Context): AppDB {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): AppDB {
            return Room.databaseBuilder(
                context,
                AppDB::class.java, DB_NAME
            ).build()
        }
    }

}