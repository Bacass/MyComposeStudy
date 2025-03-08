package com.example.viewmodelex

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

import kotlin.Exception

class MainViewModel: ViewModel() {
    var isFahrenheit by mutableStateOf(true)
    var result by mutableStateOf("_____")

    fun convertTemp(temp: String) {
        try {
            val tempInt = temp.toInt()

            if (isFahrenheit) {
                result = (((tempInt) - 32) * 0.5556).toString()
            } else {
                result = (((tempInt) * 1.8) + 32).toString()
            }

        } catch (e: Exception) {
            result = "Invalid Entry"
        }
    }

    fun switchChange() {
        isFahrenheit = !isFahrenheit
    }
}