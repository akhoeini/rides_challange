package com.amin.rides.ui.fragments

import android.app.Activity
import android.content.Context
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.amin.rides.R
import com.amin.rides.data.Vehicle
import com.amin.rides.databinding.FragmentVehicleListBinding
import com.amin.rides.ui.adapters.VehiclesAdapter
import com.amin.rides.ui.viewmodels.VehicleListViewModel
import com.amin.rides.ui.viewmodels.states.Status

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VehicleListFragment : Fragment() {


    companion object {
        fun newInstance() = VehicleListFragment()
    }

    private val viewModel: VehicleListViewModel by viewModels()

    private lateinit var binding: FragmentVehicleListBinding

    private val adapter: VehiclesAdapter = VehiclesAdapter(onItemClicked = { item:Vehicle ->
        val bundle = Bundle()
        bundle.putSerializable("vehicle",item)
        findNavController().navigate(R.id.nav_vehicle_detail, bundle)
    })


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentVehicleListBinding.inflate(inflater)

        viewModel.fetchBtnStatus.observe(viewLifecycleOwner) { btnStatus ->
            when (btnStatus) {
                VehicleListViewModel.FetchButtonStatus.FETCH -> {
                    binding.fetchBtn.isEnabled = true
                    binding.fetchBtn.text = getString(R.string.fetch)
                    binding.fetchBtn.alpha = 1f
                }

                VehicleListViewModel.FetchButtonStatus.REFRESH -> {

                    binding.fetchBtn.isEnabled = true
                    binding.fetchBtn.text = getString(R.string.refresh)
                    binding.fetchBtn.alpha = 1f

                }

                VehicleListViewModel.FetchButtonStatus.NOT_VALID -> {
                    binding.fetchBtn.isEnabled = false
                    binding.fetchBtn.text = getString(R.string.count_not_valid)
                    binding.fetchBtn.alpha = 0.7f
                }

                VehicleListViewModel.FetchButtonStatus.LOADING -> {
                    binding.fetchBtn.isEnabled = false
                    binding.fetchBtn.text = getString(R.string.loading)
                    binding.fetchBtn.alpha = 0.7f
                }
            }

        }

        viewModel.vehicles.observe(viewLifecycleOwner) { state ->
            when (state.status) {
                Status.SUCCESS -> {
                    showData(state.data)
                }

                Status.LOADING -> {
                    showLoading()
                }

                Status.ERROR -> {
                    showError(state.message)
                }
            }
        }

        setUpListeners()
        initRecycler()

        binding.dataCountEt.setText("")

        return binding.root
    }

    private fun showError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
        binding.vehicleListRecycler.visibility = View.GONE
        binding.progress.visibility = View.GONE
    }

    private fun showLoading() {
        binding.vehicleListRecycler.visibility = View.GONE
        binding.progress.visibility = View.VISIBLE
    }

    private fun showData(data: List<Vehicle>?) {
        binding.progress.visibility = View.GONE
        if (data != null) {
            binding.vehicleListRecycler.visibility = View.VISIBLE
            adapter.setData(data)
        } else {
            binding.vehicleListRecycler.visibility = View.GONE
        }
    }


    private fun setUpListeners() {
        binding.fetchBtn.setOnClickListener { view ->
            view?.let { context?.hideKeyboard(it) }
            viewModel.fetchData()
        }

        binding.dataCountEt.doAfterTextChanged { text ->
            //in the xml input type is number so it is empty or a number maybe i just need to put limit to be sure it's an int but for now i keep it simple
            viewModel.dataCountTextChanged(text.toString())
        }

    }

    private fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun initRecycler() {
        binding.vehicleListRecycler.setHasFixedSize(true)
        binding.vehicleListRecycler.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding.vehicleListRecycler.adapter = adapter
    }

}