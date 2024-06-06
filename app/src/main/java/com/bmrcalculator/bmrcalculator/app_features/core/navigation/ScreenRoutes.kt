package com.bmrcalculator.bmrcalculator.app_features.core.navigation

sealed class ScreenRoutes(val route: String) {

    object FirstScreenWebView : ScreenRoutes("first_screen_web_view")
    object SecondScreenWebView : ScreenRoutes("second_screen_web_view")

}