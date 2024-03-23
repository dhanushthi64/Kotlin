package com.example.funfacts

import androidx.compose.ui.graphics.Color
import kotlin.random.Random

object Utils {
    fun generateColor() : Color{
        return Color(
            red = Random.nextFloat(),
            blue = Random.nextFloat(),
            green = Random.nextFloat(),
            alpha = 1f
        )
    }
}