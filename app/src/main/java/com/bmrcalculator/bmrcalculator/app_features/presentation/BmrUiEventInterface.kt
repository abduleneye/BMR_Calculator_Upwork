package com.bmrcalculator.bmrcalculator.app_features.presentation

sealed interface BmrUiEventInterface {

        data class height(val text: String) : BmrUiEventInterface
        data class weight(val text: String) : BmrUiEventInterface
        data class age(val text: String) : BmrUiEventInterface
        data class answer(val text: String) : BmrUiEventInterface
        data class gender(val text: Boolean) : BmrUiEventInterface
        object Calculate: BmrUiEventInterface
        object Reset: BmrUiEventInterface
        object HideResultSheet: BmrUiEventInterface
        object ShowResultSheet: BmrUiEventInterface

        data class UpdateRadioButton(val info: RadioButtonClass
        ): BmrUiEventInterface

        data class SelectedGender(val text: String
        ): BmrUiEventInterface






}