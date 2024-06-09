package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.webkit.WebView
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bmrcalculator.bmrcalculator.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BmrCalculatorScreen(
    //url: String,
    uiStates: BmrCalculatorUiState,
    onEvent: ((BmrUiEventInterface) -> Unit),
    navController: NavController,
){
    var resultBoxVisibility = remember {
        mutableStateOf(false)
    }


    val context = LocalContext.current

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
           // .background(color = Color.White),

        topBar = {
            TopAppBar(
                title = {
                    Text(text = "BMR Calculator")
                },

                actions = {
                    IconButton(
                        onClick = {
                                  onEvent(BmrUiEventInterface.Reset)
                        },


                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.refresh),
                            contentDescription = "Reload Page"
                        )


                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                    // containerColor = Color.White
                ),


                )


        },

        ) { scaffoldPadding ->


        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = uiStates.height,
                    onValueChange = {
                        onEvent(BmrUiEventInterface.height(it))
                        onEvent(BmrUiEventInterface.HideResultSheet)

                    },
                    label = {
                        Text(text = "Height (cm)")
                    },
                    singleLine = true,

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Next

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                OutlinedTextField(
                    value = uiStates.weight,
                    onValueChange = {
                        onEvent(BmrUiEventInterface.weight(it))
                        onEvent(BmrUiEventInterface.HideResultSheet)

                    },
                    label = {
                        Text(text = "Weight (cm)")
                    },
                    singleLine = true,

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Decimal,
                        imeAction = ImeAction.Next

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp))

                Spacer(modifier = Modifier.height(4.dp))

                OutlinedTextField(
                    value = uiStates.age,
                    onValueChange = {

                        onEvent(BmrUiEventInterface.age(it))
                        onEvent(BmrUiEventInterface.HideResultSheet)

                    },
                    label = {
                        Text(text = "Age")
                    },
                    singleLine = true,

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done

                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp)

                )

                Spacer(modifier = Modifier.height(4.dp))


                RadioButtons(radioButtonStates = uiStates, onEvent = onEvent)

                Spacer(modifier = Modifier.height(4.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp),
                    onClick = {
                        onEvent(BmrUiEventInterface.Calculate)
                        resultBoxVisibility.value = !resultBoxVisibility.value
                        if (uiStates.weight == "" || uiStates.height == "" || uiStates.age == ""){
                            Toast.makeText(context, "Please enter all fields", Toast.LENGTH_SHORT).show()
                        }else{
                            onEvent(BmrUiEventInterface.ShowResultSheet)
                        }
                    }
                ) {

                    Text(text = "Calculate BMR")

                }

                //AppRatingDialogBox()
                //ShowDialogBox()

                Spacer(modifier = Modifier.height(8.dp))
                //Text(text = uiStates.newSelectedGender)


                if (
                    //resultBoxVisibility.value == true
                uiStates.resultSheetVisibility == true

                ){

                    Card(
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .fillMaxHeight(0.8f)
                            .clip(shape = RoundedCornerShape(15.dp))
                        //.background(color = Color.Blue)
                        ,
                        elevation = CardDefaults.cardElevation(10.dp)
                        //contentAlignment = Alignment.Center
                    ){

                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {

                            Text(text = "Your BMR is:")
                            Text(text = uiStates.result)
                            Text(text = "Kcal/Day")



                        }

                    }

                }


            }




        }
    }
}

@Composable
fun RadioButtons(radioButtonStates: BmrCalculatorUiState, onEvent: (BmrUiEventInterface) -> Unit){
//    val radioButtons = remember {
//        mutableStateListOf(
//            RadioButtonClass(
//                isChecked = true,
//                gender = "Male"
//            ),
//            RadioButtonClass(
//                isChecked = false,
//                gender = "Female"
//            )
//        )
//    }

    //HELPER
//    val list = mutableListOf("Male", "Female")
//    var selectedGender by rememberSaveable {
//        mutableStateOf(list[0])
//    }

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp)
        ,
        horizontalAlignment = Alignment.Start
    ) {
        Text(text = "Your Gender:")
        radioButtonStates.list.forEach{item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                       // onEvent(BmrUiEventInterface.UpdateRadioButton(info))

//                        TODO()

                    }
            ){

                RadioButton(
                    selected = item == radioButtonStates.newSelectedGender,
                    onClick = {
                       // selectedGender = item
                        //Toast.makeText(context, "${radioButtonStates.newselectedGender} selected", Toast.LENGTH_SHORT).show()
                        onEvent(BmrUiEventInterface.HideResultSheet)
                        onEvent(BmrUiEventInterface.SelectedGender(item))
                        //TODO()


                        //onEvent(BmrUiEventInterface.UpdateRadioButton(info))


                    }
                )
                Text(text = item)

            }

        }
    }



}


