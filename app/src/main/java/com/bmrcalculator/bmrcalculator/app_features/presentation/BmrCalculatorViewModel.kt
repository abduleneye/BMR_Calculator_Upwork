package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BmrCalculatorViewModel: ViewModel() {

    private val _bmrCalculatorUiState =
        MutableStateFlow(BmrCalculatorUiState())
    val bmrCalculatorUiState = _bmrCalculatorUiState.asStateFlow()

    fun onEvent(event: BmrUiEventInterface){
        when(event){
            BmrUiEventInterface.Calculate ->{
                BmrCalculation()
                Log.d("CalculatedResult", _bmrCalculatorUiState.value.result)
            }
            BmrUiEventInterface.Reset ->{

                _bmrCalculatorUiState.update {
                    it.copy(
                        height = "",
                        weight = "",
                        age = "",
                        result = "",
                        resultSheetVisibility = false,
                        newSelectedGender = _bmrCalculatorUiState.value.list[0],
                        selectedGender = "Male",
                        )
                }

            }

            is BmrUiEventInterface.age ->{
                _bmrCalculatorUiState.update {
                    it.copy(
                        age = event.text
                    )
                }
            }
            is BmrUiEventInterface.answer ->{


            }
            is BmrUiEventInterface.gender -> {

            }
            is BmrUiEventInterface.height -> {

                _bmrCalculatorUiState.update {
                    it.copy(
                        height = event.text
                    )
                }

            }
            is BmrUiEventInterface.weight -> {
                _bmrCalculatorUiState.update {
                    it.copy(
                        weight = event.text
                    )
                }
            }
            is BmrUiEventInterface.ShowResultSheet -> {
                _bmrCalculatorUiState.update {
                    it.copy(
                        resultSheetVisibility = true
                    )
                }
            }

            is BmrUiEventInterface.HideResultSheet -> {
                _bmrCalculatorUiState.update {
                    it.copy(
                        resultSheetVisibility = false
                    )
                }
            }

            is BmrUiEventInterface.UpdateRadioButton -> {

//                _bmrCalculatorUiState.update {
//                    it.copy(
//                        radioButtons =
//                    )
//                }
//
//                _bmrCalculatorUiState.value.radioButtons.replaceAll{
//                    it.copy(
//                        isChecked = it.gender == event.info.gender
//                    )
//                }
//
//
//
//                _bmrCalculatorUiState.update {
//                    it.copy(
//                        resultSheetVisibility = false
//                    )
//                }
            }

            is BmrUiEventInterface.SelectedGender -> {
                _bmrCalculatorUiState.update {
                    it.copy(
                        //selectedGender = event.text,
                        newSelectedGender = event.text
                    )
                }
            }
        }

    }

    fun BmrCalculation() {

        fun roundUpTo2Dp(value: Double): String{
            return String.format("%.2f", value)

        }

        if (
            _bmrCalculatorUiState.value.weight != "" && _bmrCalculatorUiState.value.height != "" && _bmrCalculatorUiState.value.age != "") {
            if (_bmrCalculatorUiState.value.newSelectedGender == "Male") {

                var maleResult = (66.47) + (13.75 * _bmrCalculatorUiState.value.weight.toDouble() ) + (5.003 * _bmrCalculatorUiState.value.height.toDouble()) - (6.755 * _bmrCalculatorUiState.value.age.toDouble())
                _bmrCalculatorUiState.update {
                    it.copy(
                        result = roundUpTo2Dp(maleResult),
                        resultSheetVisibility = true
                    )
                }

                Log.d("MaleResult", maleResult.toString())


            } else if (_bmrCalculatorUiState.value.newSelectedGender == "Female") {

                var femaleResult = (655.1) + (9.563 * _bmrCalculatorUiState.value.weight.toDouble()) + (1.85 * _bmrCalculatorUiState.value.height.toDouble()) - (4.676 * _bmrCalculatorUiState.value.age.toDouble() )
                _bmrCalculatorUiState.update {
                    it.copy(
                        result = roundUpTo2Dp(femaleResult),
                        resultSheetVisibility = true
                    )
                }
                Log.d("FemaleResult", femaleResult.toString())



            }
        } else {

        }


    }
}