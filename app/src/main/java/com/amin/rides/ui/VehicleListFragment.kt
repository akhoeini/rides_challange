package com.amin.rides.ui

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.amin.rides.R
import com.amin.rides.databinding.FragmentVehicleListBinding
import com.amin.rides.ui.adapters.VehiclesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleListFragment : Fragment() {


    companion object {
        fun newInstance() = VehicleListFragment()
    }

    private val viewModel: VehicleListViewModel by viewModels()

    private lateinit var binding: FragmentVehicleListBinding

    private val adapter: VehiclesAdapter = VehiclesAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVehicleListBinding.inflate(inflater)


        initRecycler()

        return binding.root
    }

    private fun initRecycler() {
        binding.vehicleListRecycler.setHasFixedSize(true)
        binding.vehicleListRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.vehicleListRecycler.adapter = adapter
    }
}