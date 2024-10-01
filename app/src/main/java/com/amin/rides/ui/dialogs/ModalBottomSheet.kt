package com.amin.rides.ui.dialogs

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.amin.rides.R
import com.amin.rides.databinding.ModalBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

open class ModalBottomSheet :BottomSheetDialogFragment() {
    private lateinit var binding: ModalBottomSheetBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding=ModalBottomSheetBinding.inflate(inflater)
        return binding.root

    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }
}