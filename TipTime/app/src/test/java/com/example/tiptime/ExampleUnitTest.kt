package com.example.tiptime

import java.text.NumberFormat.getCurrencyInstance
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ExampleUnitTest {
    @Test
    fun calculateTip_20Percent() {
        val amount = 10.00
        val tipPercent = 20.00
        val expectedOutput = getCurrencyInstance().format(2)
        val actualOutput = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)
        assertEquals(expectedOutput, actualOutput)
    }
}