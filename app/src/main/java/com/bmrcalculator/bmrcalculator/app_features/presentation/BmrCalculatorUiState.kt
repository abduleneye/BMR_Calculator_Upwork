package com.bmrcalculator.bmrcalculator.app_features.presentation

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember

data class BmrCalculatorUiState(
    var height: String = "",
    var  weight : String = "",
    var age: String = "",
    var result: String = "",
    var radioButtons: MutableList<RadioButtonClass> = mutableListOf<RadioButtonClass>(RadioButtonClass(
        isChecked = true,
        gender = "Male"
    ),
        RadioButtonClass(
            isChecked = false,
            gender = "Female"
        )),
    var resultSheetVisibility: Boolean = false,

    var selectedGender: String = "Male",

    val list: MutableList<String> = mutableListOf("Male", "Female"),
    var newSelectedGender: String = list[0]





)
