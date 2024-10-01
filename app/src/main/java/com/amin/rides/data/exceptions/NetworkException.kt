package com.amin.rides.data.exceptions

class NetworkException : Exception(message){

    companion object {
        const val message = "An error occurred while retrieving data from the server"
    }
}