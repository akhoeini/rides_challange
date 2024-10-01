package com.amin.rides.ui.viewmodels.states

data class VehicleListState<out T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): VehicleListState<T> {
            return VehicleListState(Status.SUCCESS, data, null)
        }

        fun <T> empty(): VehicleListState<T> {
            return VehicleListState(Status.SUCCESS, null, null)
        }


        fun <T> error(msg: String?): VehicleListState<T> {
            return VehicleListState(Status.ERROR, null, msg)
        }



        fun <T> loading(): VehicleListState<T> {
            return VehicleListState(Status.LOADING, null, null)
        }
    }
}

enum class Status{
    SUCCESS,
    ERROR,
    LOADING,
}