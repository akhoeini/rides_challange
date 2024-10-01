package com.amin.rides.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.amin.rides.data.Vehicle
import com.amin.rides.data.repositories.network.NetworkRepo
import com.amin.rides.data.wrappers.VehicleDataWrapper
import com.amin.rides.ui.viewmodels.states.VehicleListState
import com.amin.rides.utils.Util
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class VehicleListViewModel @Inject internal constructor(private val vehicleDataWrapper: VehicleDataWrapper, private val util: Util) :
    ViewModel() {

    private var _dataCount: Int? = null
    val dataCount: Int? get() = _dataCount

    //immutable for observing observe
    val vehicles: LiveData<VehicleListState<List<Vehicle>>> get() = _vehicles
    private val _vehicles = MutableLiveData<VehicleListState<List<Vehicle>>>()

    //immutable for observing observe
    val fetchBtnStatus: LiveData<FetchButtonStatus> get() = _fetchBtnStatus
    private val _fetchBtnStatus = MutableLiveData<FetchButtonStatus>()


    init {
        _fetchBtnStatus.value=FetchButtonStatus.NOT_VALID
        _vehicles.value=VehicleListState.empty()
    }
    fun fetchData() {
        loadVehicles()
    }

    private fun loadVehicles() {
        if (_dataCount != null) {
            _vehicles.value = VehicleListState.loading()
            _fetchBtnStatus.value=FetchButtonStatus.LOADING


            viewModelScope.launch {
                val state=withContext(Dispatchers.IO) {
                    try {
                        //for now we have one filter to sort our data so i hard coded "vin"
                        val vehicles =
                            vehicleDataWrapper.getVehiclesByCountAndFilter(_dataCount!!, "vin")
                        VehicleListState.success(vehicles)

                    } catch (exception: Exception) {
                        VehicleListState.error(exception.message)
                    }
                }
                _vehicles.value= state
                _fetchBtnStatus.value=FetchButtonStatus.REFRESH
            }
        }
    }

    fun dataCountTextChanged(countText: String) {
        if (util.countTextIsValid(countText)){
            _dataCount=countText.toInt()
            _fetchBtnStatus.value=FetchButtonStatus.FETCH
        }else{
            _dataCount=null
            _fetchBtnStatus.value=FetchButtonStatus.NOT_VALID
        }
    }



    enum class FetchButtonStatus{
        FETCH,
        REFRESH,
        NOT_VALID,
        LOADING
    }

}