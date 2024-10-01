package com.amin.rides.utils

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Util @Inject constructor() {
    fun countTextIsValid(countText: String): Boolean {
        try {
            val countValue=countText.toInt()
            if (countValue<1||countValue>100) {
                return false
            }
        }catch (exception:NumberFormatException){
            return false
        }
        return true
    }
}