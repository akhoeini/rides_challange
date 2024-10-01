package com.amin.rides.ui.dialogs

import org.junit.Assert.*

import org.junit.Test

class VehicleDetailBottomSheetTest {

    @Test
    fun calculateEmission() {
        //negative
        assertEquals(0.0, VehicleDetailBottomSheet(-5).calculateEmission(),0.00)

        //lower limit
        assertEquals(0.0, VehicleDetailBottomSheet(0).calculateEmission(),0.01)

        //inside range
        assertEquals(2546.0, VehicleDetailBottomSheet(2546).calculateEmission(),0.00)

        //upper limit
        assertEquals(5000.0, VehicleDetailBottomSheet(5000).calculateEmission(),0.00)


        assertEquals(5001.5, VehicleDetailBottomSheet(5001).calculateEmission(),0.00)

        assertEquals(6500.0, VehicleDetailBottomSheet(6000).calculateEmission(),0.00)


    }
}