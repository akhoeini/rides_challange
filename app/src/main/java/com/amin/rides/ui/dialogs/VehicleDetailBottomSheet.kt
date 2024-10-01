package com.amin.rides.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amin.rides.databinding.VehicleDetailBottomSheetBinding
import javax.inject.Inject
import kotlin.math.max
import kotlin.math.min


class VehicleDetailBottomSheet(private val kilomtrage: Int) : ModalBottomSheet() {
    private lateinit var binding: VehicleDetailBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = VehicleDetailBottomSheetBinding.inflate(inflater)
        val emission = calculateEmission()
        binding.emissionEstimation.text = "$emission UOC/KM"



        return binding.root
    }


    fun calculateEmission(): Double {
        return max(0, kilomtrage - 5000) * 1.5 + min(max(kilomtrage, 0), 5000) * 1
    }
}