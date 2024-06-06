package com.bmrcalculator.bmrcalculator.app_features.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bmrcalculator.bmrcalculator.app_features.presentation.FirstScreenWebView
import com.bmrcalculator.bmrcalculator.app_features.presentation.SecondScreenWebView

@Composable
fun NavGraph(
    navController: NavHostController,

) {

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.FirstScreenWebView.route
    ) {
        composable(route = ScreenRoutes.FirstScreenWebView.route) {
            FirstScreenWebView(
                url = "https://www.google.com",
                navController = navController
            )


        }

        composable(route = ScreenRoutes.SecondScreenWebView.route) {

            SecondScreenWebView(
                url = "https://www.diabetes.co.uk/bmr-calculator.html",
                navController = navController
            )


            }


        }
        
        
    }
        

        
