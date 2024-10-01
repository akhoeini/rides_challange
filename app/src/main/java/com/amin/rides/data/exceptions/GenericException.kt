package com.amin.rides.data.exceptions

class GenericException : Exception(message) {

    companion object {
        const val message = "An unexpected error has occurred"
    }
}
