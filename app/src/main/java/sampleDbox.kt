//package com.bmrcalculator.bmrcalculator
//
//import android.os.Bundle
//import android.widget.Toast
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.BottomSheetState
//import androidx.compose.material3.Card
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
//import androidx.compose.material.TextFieldDefaults
//import androidx.compose.material3.Button
//import androidx.compose.material3.ButtonDefaults
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import androidx.compose.ui.window.Dialog
//import androidx.compose.ui.window.DialogProperties
//
//
//
//@Composable
//fun FourSgpaSaveResultDialogBox(
//    dbState: FourSgpaUiStates,
//
//
//
//) {
//
//    val scope = rememberCoroutineScope()
//    val context = LocalContext.current
//
//
//    Dialog(
//        onDismissRequest = {
//
//        },
//        properties = DialogProperties(
//            dismissOnBackPress = true,
//            dismissOnClickOutside = true,
//            //securePolicy = SecureFlagPolicy.SecureOn,
//        )
//    ) {
//
//
//        Card(
//            elevation = 8.dp,
//            shape = RoundedCornerShape(20.dp),
//            modifier = Modifier
//                .fillMaxWidth(0.9f),
//
//            backgroundColor = Cream
//
//        ) {
//            Column {
//
//
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 16.dp)
//                ) {
//                    Column {
//                        Text(
//                            text = "Save result As:",
//                            modifier = Modifier
//                                .align(Alignment.Start)
//                                .padding(start = 20.dp),
//                            fontSize = 18.sp,
//                            fontWeight = FontWeight.W400
//                        )
//                    }
//                }
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//                OutlinedTextField(
//                    modifier = Modifier
//                        .align(Alignment.Start)
//                        .padding(start = 20.dp, end = 8.dp),
//                    value = dbState.saveResultAs,
//                    onValueChange = {
//
//                        onEvent(FourGpaUiEvents.setSRA(it))
//                        onEvent(FourGpaUiEvents.resetBackToDefaultValueFromErrorSRA)
//
//
//                    },
//                    label = {
//                        Text(text = dbState.defaultLabelSRA)
//                    },
//                    singleLine = true,
//                    colors = TextFieldDefaults.outlinedTextFieldColors(
//                        focusedLabelColor = Color(dbState.defaultLabelColourSRA),
//                        focusedBorderColor = Color(dbState.defaultLabelColourSRA),
//                    ),
//
//
//                    )
//
//
//                Spacer(modifier = Modifier.height(8.dp))
//
//
//
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 0.dp),
//                    contentAlignment = Alignment.BottomCenter,
//
//                    ) {
//
//
//                    Row(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .padding(end = 15.dp, bottom = 4.dp, top = 8.dp),
//                        horizontalArrangement = Arrangement.End
//
//                    ) {
//
//                        Button(
//                            onClick = {
//                                onEvent(FourGpaUiEvents.hideFourSgpaSaveResultDB)
//                                onEvent(FourGpaUiEvents.resetBackToDefaultValueFromErrorSRA)
//
//                            },
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = AppBars
//                            ),
//                        ) {
//
//                            Text(text = "Cancel")
//
//
//                        }
//
//                        Spacer(
//                            modifier = Modifier
//                                .width(16.dp)
//                        )
//
//
//
//                        Button(
//                            onClick = {
//
//                                // if (dbState.saveResultAs.isNotEmpty()) {
//
//                                val params = Bundle()
//                                params.putString(
//                                    "FourSgpaSaveResultButton",
//                                    "FourSgpaSaveResultButtonClicked"
//                                )
//                                mFirebaseAnalytics.logEvent("FourSgpaSaveResultButton", params)
//
//
//                                onEvent(FourGpaUiEvents.saveFourSgpaResult)
//                                //onEvent(FourGpaUiEvents.hideFiveCgpaSaveResultDB)
//
//
//                                if (dbState.saveResultAs.isNotEmpty()) {
//                                    Toast.makeText(
//                                        context,
//                                        "${dbState.saveResultAs} saved in records successfully!!!",
//                                        Toast.LENGTH_SHORT
//                                    ).show()
//                                }
//
//                                //}
//
//                                //Toast.makeText(context, "Saved", Toast.LENGTH_LONG).show()
//                                //onEvent(FourGpaUiEvents.hideFiveSgpaSaveResultDB)
//
//
//                            },
//                            colors = ButtonDefaults.buttonColors(
//                                containerColor = AppBars
//                            ),
//                        ) {
//
//                            Text(text = "Save")
//
//                        }
//
//
//                    }
//
//
//                }
//
//            }
//
//
//        }
//
//    }
//
//
//}