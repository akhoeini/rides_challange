package com.amin.rides.data

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Vehicle(
    val id:Long,
    val uid:String,
    val vin:String,
    @SerializedName("make_and_model")val makeModel:String,
    val color:String,
    val transmission:String,
    @SerializedName("drive_type")val driveType:String,
    @SerializedName("fuel_type")val fuelType:String,
    @SerializedName("car_type")val carType:String,
    @SerializedName("car_options")val carOptions:List<String>,
    val specs:List<String>,
    val doors:Int,
    val mileage:Int,
    val kilometrage:Int,
    @SerializedName("license_plate")val licensePlate:String
    ):Serializable