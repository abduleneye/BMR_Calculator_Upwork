package com.bmrcalculator.bmrcalculator.app_features.presentation
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.ExperimentalMaterialApi
import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DialogBoxVisibilityController
import kotlinx.coroutines.launch


//@OptIn(ExperimentalMaterialApi::class)
@Composable
fun AppRatingDialogBox(
   // demoQuizOnEvent: (DemoQuizUiEventClass) -> Unit,


    ) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    val dataStore = DialogBoxVisibilityController(context)



    Dialog(
        onDismissRequest = {
            //demoQuizOnEvent(DemoQuizUiEventClass.hideIntroDialogBoxVisibilty)

        },
//        properties = DialogProperties(
//            dismissOnBackPress = true,
//            dismissOnClickOutside = true,
//            //securePolicy = SecureFlagPolicy.SecureOn,
//        )
    ) {


        Card(
           // elevation = 8.dp,
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxSize(0.5f)
                .background(color = Color.Green)
                .fillMaxHeight(0.5f)
                .fillMaxWidth(0.9f),

           // backgroundColor = Cream

        ) {
            Column(
                //horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    //.fillMaxWidth()
                    .fillMaxHeight(0.9f)
            ) {


                LazyColumn(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .fillMaxSize()
                        .weight(0.5f)
                ) {

                    item {
                        Text(
                            text = "Rate App",
                            modifier = Modifier
                                .align(Alignment.Start)
                                .fillMaxWidth()
                                .padding(start = 20.dp, top = 16.dp, end = 8.dp)
                                .weight(1f),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.W400,
                            lineHeight = 29.sp
                        )
                    }

                }


                Spacer(modifier = Modifier.height(0.dp))



                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        //  .fillMaxHeight()
                        .padding(bottom = 24.dp),
                    contentAlignment = Alignment.BottomCenter,

                    ) {


                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        // .padding(end = 15.dp, bottom = 2.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally


                    ) {

//
//                        Spacer(
//                            modifier = Modifier
//                                .width(16.dp)
//                        )

                        Button(
                            onClick = {
                                scope.launch {
                                    //dataStore.saveQuizIntroDialogBoxVisibilityStatus(false)
                                }
                            },
                            colors = ButtonDefaults.buttonColors(
                               // containerColor = AppBars
                            ),
                            modifier = Modifier
                                .fillMaxWidth(0.9f)
                        ) {

                            Text(text = "RATE US")

                        }


                    }


                }

            }


        }

    }


}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun QuizIntoDialogBox(

) {
    //QuizIntroDialogBox()
    Text(text = "Hello", modifier = Modifier.fillMaxSize())
}