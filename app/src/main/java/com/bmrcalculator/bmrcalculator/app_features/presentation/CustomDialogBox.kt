package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import java.util.Locale
import coil.decode.GifDecoder



@Composable
fun CustomDialogBox(
    title: String,
    message: String,
    recommend: String,
    onDismiss: ()-> Unit,
    onPositiveButtonClicked: ()-> Unit,
    onNegativeButtonClicked: ()-> Unit,
    properties: DialogProperties = DialogProperties()


){

    val context = LocalContext.current

    Dialog(onDismissRequest = onDismiss,  properties = properties) {

        Card(
            elevation = 8.dp,
            //shape = RoundedCornerShape(20.dp)
        ) {

            Column(modifier = Modifier
                .fillMaxWidth(0.7f)
                .padding(16.dp))
            {

                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.Red,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable(onClick = onDismiss)
                )

                Spacer(modifier = Modifier.padding(top = 5.dp))

//                Text(text = title, style = TextStyle(
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.SemiBold
//                )
//                )
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("file:///android_asset/kawaii_cute.gif")
                        .decoderFactory(GifDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
//                    modifier = Modifier
//                        .fillMaxSize()
                )

                Spacer(modifier = Modifier
                    .padding(top = 8.dp))

                Text(
                    text = message,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Text(
                    text = recommend,
                    style = MaterialTheme.typography.caption,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.padding(top = 8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

//                    TextButton(onClick = onNegativeButtonClicked,
//                        colors = ButtonDefaults.buttonColors(
//                            backgroundColor = Color.DarkGray,
//                            contentColor = Color.White
//                        )) {
//                        Text(text = "Cancel")
//                    }
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                        ,

                                onClick = {

                                    onPositiveButtonClicked
                                    openPlayStoreReviewPage(context = context)
                                },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Yellow,
                            contentColor = Color.White,

                            ),) {

                        Text(text = "RATE US")

                    }

                }

            }

        }
    }

}



@Composable
fun ShowDialogBox(){

    var showDialog by remember{
        mutableStateOf(false)
    }

    val Context = LocalContext.current

    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button(onClick = {showDialog = true}) {

            Text(text = "ShowCustomDialog")

        }

        if (showDialog){
            CustomDialogBox(
                title = "lorem Ipsum",
                message = "Like using Zeta app?",
                recommend = "Recommend us to others by \n rating us on Play Store",
                onDismiss = { showDialog = false
                    Toast.makeText(Context,"Dismissed",Toast.LENGTH_SHORT).show()},
                onPositiveButtonClicked = {
                    showDialog = false
                    Toast.makeText(Context, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
                },
                onNegativeButtonClicked = {
                    showDialog = false
                    Toast.makeText(Context, "Negative Button Clicked", Toast.LENGTH_SHORT).show()

                })
        }

    }
}

fun openPlayStoreReviewPage(context: Context){
    val appPackageName = context.packageName
    try{

        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("market://details?id=$appPackageName&reviewId=0")
            )
        )

    }catch (e: android.content.ActivityNotFoundException){
        context.startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/stor/apps/details?id=$appPackageName&reviewId=0")
            )
        )
        
    }

}