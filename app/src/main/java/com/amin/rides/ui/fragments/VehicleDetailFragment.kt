package com.amin.rides.ui.fragments

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amin.rides.R
import com.amin.rides.ui.viewmodels.VehicleDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleDetailFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleDetailFragment()
    }

    private val viewModel: VehicleDetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_vehicle_detail, container, false)
    }
}