package com.amin.rides.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable

@Entity(tableName = "vehicle")
data class Vehicle(
    val id:Long,
    @PrimaryKey val uid:String,
    @ColumnInfo val vin:String,
    @SerializedName("make_and_model") @ColumnInfo val makeModel:String,
    @ColumnInfo val color:String,
    val transmission:String,
    @SerializedName("drive_type") @ColumnInfo val driveType:String,
    @SerializedName("fuel_type")val fuelType:String,
    @SerializedName("car_type") @ColumnInfo val carType:String,
    @SerializedName("car_options") @ColumnInfo val carOptions:List<String>,
    val specs:List<String>,
    val doors:Int,
    @ColumnInfo val mileage:Int,
    @ColumnInfo val kilometrage:Int,
    @SerializedName("license_plate")val licensePlate:String
    ):Serializable