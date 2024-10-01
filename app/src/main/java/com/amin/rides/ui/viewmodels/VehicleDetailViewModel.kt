package com.amin.rides.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.amin.rides.data.Vehicle
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleDetailViewModel@Inject internal constructor(): ViewModel() {

    val vehicle: LiveData<Vehicle> get() = _vehicle
    private val _vehicle = MutableLiveData<Vehicle>()

    fun setVehicleDetail(vehicle: Vehicle){
        _vehicle.value=vehicle
    }

}