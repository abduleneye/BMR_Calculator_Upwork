package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.decode.GifDecoder
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DataStoreViewModel

@Composable
fun AppRatingDialogBox(
    message: String,
    recommend: String,
    onDismiss: ()-> Unit,
    onPositiveButtonClicked: ()-> Unit,
    properties: DialogProperties = DialogProperties()
){




    val context = LocalContext.current
    val scope = rememberCoroutineScope()



    Dialog(onDismissRequest = onDismiss,  properties = properties) {

        Card(
            elevation = 8.dp,
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
                        .clickable(onClick = onDismiss )
                )

                Spacer(modifier = Modifier.padding(top = 5.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data("file:///android_asset/kawaii_cute.gif")
                        .decoderFactory(GifDecoder.Factory())
                        .crossfade(true)
                        .build(),
                    contentDescription = null,

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

                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(0.dp)
                        ,

                                onClick = onPositiveButtonClicked,
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
fun ShowDialogBox(
    viewModel: DataStoreViewModel
){
    //
    val entryCount by viewModel.entryCount.collectAsState()
    val DialogShown by viewModel.DialogShown.collectAsState()

    var showDi by remember(entryCount, DialogShown) {
       mutableStateOf(entryCount > 1 && DialogShown)
    }

    //

    val context = LocalContext.current






    Column(modifier = Modifier
        .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        if (entryCount == 2 && DialogShown == false){
            AppRatingDialogBox(
                message = "Like using Zeta app?",
                recommend = "Recommend us to others by \n rating us on Play Store",
                onDismiss = {
                    //viewModel.updateDialogShown(true)
                    viewModel.resetDialogBoxStatusToDefault()
                    Toast.makeText(context,"Dismissed ${viewModel.DialogShown}",Toast.LENGTH_SHORT).show()},
                onPositiveButtonClicked = {
                    openPlayStoreReviewPage(context = context)
                    viewModel.updateDialogShown(true)
                    Toast.makeText(context,"Condi ${viewModel.DialogShown.value}",Toast.LENGTH_SHORT).show()
                    Toast.makeText(context, "Positive Button Clicked", Toast.LENGTH_SHORT).show()
                },
            )
        }

    }
}

fun openPlayStoreReviewPage(context: Context){
    val appPackageName = context.packageName
    //"com.engpacalculator.gpcalculator"
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