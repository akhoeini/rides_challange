package com.amin.rides.data

data class Vehicle(
    val id:Long,
    val uid:String,
    val vin:String,
    val makeModel:String,
    val color:String,
    val transmission:String,
    val driveType:String,
    val fuelType:String,
    val carType:String,
    val carOptions:List<String>,
    val specs:List<String>,
    val doors:Int,
    val mileage:Int,
    val kilometrage:Int,
    val licensePlate:String
    )