package com.bmrcalculator.bmrcalculator.app_features.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

data class BmrCalculatorUiState(
    var height: String = "",
    var  weight : String = "",
    var age: String = "",
    var result: String = "",
    val radioButtons: MutableList<RadioButtonClass> = mutableListOf<RadioButtonClass>(RadioButtonClass(
        isChecked = true,
        gender = "Male"
    ),
        RadioButtonClass(
            isChecked = false,
            gender = "Female"
        )),
    val resultSheetVisibility: Boolean = false




)
