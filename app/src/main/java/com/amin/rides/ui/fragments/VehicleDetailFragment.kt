package com.amin.rides.ui.fragments

import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amin.rides.R
import com.amin.rides.data.Vehicle
import com.amin.rides.databinding.FragmentVehicleDetailBinding
import com.amin.rides.databinding.FragmentVehicleListBinding
import com.amin.rides.ui.dialogs.ModalBottomSheet
import com.amin.rides.ui.dialogs.VehicleDetailBottomSheet
import com.amin.rides.ui.viewmodels.VehicleDetailViewModel
import com.amin.rides.ui.viewmodels.VehicleListViewModel
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleDetailFragment : Fragment() {

    companion object {
        fun newInstance() = VehicleDetailFragment()
    }

    private val viewModel: VehicleDetailViewModel by viewModels()

    private lateinit var binding: FragmentVehicleDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val vehicle:Vehicle= arguments?.get("vehicle") as Vehicle
        viewModel.setVehicleDetail(vehicle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVehicleDetailBinding.inflate(inflater)

        viewModel.vehicle.observe(viewLifecycleOwner) { vehicle ->
            binding.detailVinTv.text=vehicle.vin
            binding.detailMakeModelTv.text=vehicle.makeModel
            binding.detailColorTv.text=vehicle.color
            binding.detailCarTypeTv.text=vehicle.carType

        }
        setUpListeners()

        return binding.root

    }

    private fun setUpListeners() {
        binding.btnCarbonEmissions.setOnClickListener { view ->
            showBottomSheetDialog()
        }
    }

    private fun showBottomSheetDialog() {
        if (viewModel.vehicle.value!=null) {
            val bottomSheet=VehicleDetailBottomSheet(viewModel.vehicle.value!!.kilometrage).let { it ->
                it.show(parentFragmentManager, ModalBottomSheet.TAG)
                it.view?.let {view ->
                    BottomSheetBehavior.from(view).peekHeight=BottomSheetBehavior.PEEK_HEIGHT_AUTO

                }
            }


        }
    }
}