package com.bmrcalculator.bmrcalculator.app_features.presentation

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

            }
            BmrUiEventInterface.Reset ->{

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
        }

    }

    fun BmrCalculation(gender: String) {

        if (
            _bmrCalculatorUiState.value.weight == "" || _bmrCalculatorUiState.value.height == "" || _bmrCalculatorUiState.value.age == "") {
            if (gender == "Male") {

                var result = ""

            } else if (gender == "Female") {

                var result = ""


            }
        } else {

        }


    }
}