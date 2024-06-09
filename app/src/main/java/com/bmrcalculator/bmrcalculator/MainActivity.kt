package com.bmrcalculator.bmrcalculator

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.collectAsState

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.bmrcalculator.bmrcalculator.app_features.core.navigation.NavGraph
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DataStoreViewModel
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DataStoreViewModelFactory
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.PreferencesRepository
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorViewModel

class MainActivity : ComponentActivity() {

    val viewModel: DataStoreViewModel by viewModels<DataStoreViewModel> {
        DataStoreViewModelFactory(PreferencesRepository(this))

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Log.d("incremented status", "${viewModel.entryCount.collectAsState().value}")


            val navController = rememberNavController()
            val bmrViewModel = viewModel<BmrCalculatorViewModel>()



            NavGraph(
                bmrCalculatorViewModel = bmrViewModel,
                navController = navController,
                viewModel = viewModel
            )
            
            
        }
    }
}
