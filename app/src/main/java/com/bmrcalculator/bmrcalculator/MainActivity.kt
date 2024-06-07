package com.bmrcalculator.bmrcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.bmrcalculator.bmrcalculator.app_features.core.navigation.NavGraph
import com.bmrcalculator.bmrcalculator.app_features.presentation.BmrCalculatorViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            BMRCalculatorTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    Greeting("Android")
//                }
//            }

            val navController = rememberNavController()
            val bmrViewModel = BmrCalculatorViewModel()


            NavGraph(
                bmrCalculatorViewModel = bmrViewModel,
                navController = navController
            )
            
            
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BMRCalculatorTheme {
//        Greeting("Android")
//    }
//}