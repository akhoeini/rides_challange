package com.amin.rides.utils

import org.junit.Assert.*

import org.junit.Test

class UtilTest {

    @Test
    fun countTextIsValid() {
        //empty
        assertFalse( Util().countTextIsValid(""))
        //blank
        assertFalse( Util().countTextIsValid("  "))

        //string with non numerical chars
        assertFalse( Util().countTextIsValid("123eq1"))

        //Int overflow
        assertFalse( Util().countTextIsValid("123456789654123658478965478741321564654564654"))

        //Int overflow
        assertFalse(Util().countTextIsValid("-12345678965412365847896547874132113214564654564"))
        //Double
        assertFalse( Util().countTextIsValid("1.1"))

        //negative
        assertFalse( Util().countTextIsValid("-2"))

        //boundary
        assertFalse( Util().countTextIsValid("0"))
        assertFalse( Util().countTextIsValid("101"))
        assertTrue( Util().countTextIsValid("100"))
        assertTrue( Util().countTextIsValid("1"))


        //inside rang
        assertTrue( Util().countTextIsValid("34"))







    }
}