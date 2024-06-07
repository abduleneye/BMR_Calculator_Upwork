package com.bmrcalculator.bmrcalculator.app_features.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bmrcalculator.bmrcalculator.app_features.presentation.FirstScreenWebView
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorScreen
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    bmrCalculatorViewModel: BmrCalculatorViewModel,
    ) {
    val context = LocalContext.current
    val bmrUiStates by bmrCalculatorViewModel.bmrCalculatorUiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.FirstScreenWebView.route
    ) {
        composable(route = ScreenRoutes.FirstScreenWebView.route) {
            FirstScreenWebView(url = "https://ltobet.gb.net/test2/",
                navController = navController
            )
//            BmrCalculatorScreen(
//                //url = "https://www.diabetes.co.uk/bmr-calculator.html",
//                navController = navController,
//                uiStates = bmrUiStates,
//                onEvent = bmrCalculatorViewModel::onEvent
//
//            )



        }

        composable(route = ScreenRoutes.SecondScreenWebView.route) {

            BmrCalculatorScreen(
                //url = "https://www.diabetes.co.uk/bmr-calculator.html",
                navController = navController,
                uiStates = bmrUiStates,
                onEvent = bmrCalculatorViewModel::onEvent

            )


            }


        }
        
        
    }
        

        
