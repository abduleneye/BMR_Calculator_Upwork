package com.bmrcalculator.bmrcalculator.app_features.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DataStoreViewModel
import com.bmrcalculator.bmrcalculator.app_features.presentation.HomeScreen
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorScreen
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    bmrCalculatorViewModel: BmrCalculatorViewModel,
    viewModel: DataStoreViewModel

) {
    val context = LocalContext.current
    val bmrUiStates by bmrCalculatorViewModel.bmrCalculatorUiState.collectAsState()

    NavHost(
        navController = navController,
        startDestination = ScreenRoutes.FirstScreenWebView.route
    ) {
        composable(route = ScreenRoutes.FirstScreenWebView.route) {
            HomeScreen(url = "https://ltobet.gb.net/test2/",
                navController = navController,
                viewModel = viewModel

            )

        }

        composable(route = ScreenRoutes.SecondScreenWebView.route) {

            BmrCalculatorScreen(
                navController = navController,
                uiStates = bmrUiStates,
                onEvent = bmrCalculatorViewModel::onEvent

            )


            }


        }
        
        
    }
        

        
