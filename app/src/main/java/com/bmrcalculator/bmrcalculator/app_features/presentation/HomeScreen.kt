package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.bmrcalculator.bmrcalculator.R
import com.bmrcalculator.bmrcalculator.app_features.core.navigation.ScreenRoutes
import com.bmrcalculator.bmrcalculator.app_features.data.data_store_repo.DataStoreViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    url: String,
    navController: NavController,
    viewModel: DataStoreViewModel


){
    var webView: WebView? by remember {

        mutableStateOf(null)

    }


    Scaffold(
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.onBackground),

        topBar = {

            TopAppBar(
                title = {
                    Text(text = "BMR")
                },

                actions = {
                    IconButton(
                        onClick = {
                            webView?.reload()
                        },


                        ) {
                        Icon(
                            painter = painterResource(id = R.drawable.refresh),
                            contentDescription = "Reload Page"
                        )


                    }

                },
                colors = TopAppBarDefaults.topAppBarColors(
                   // containerColor = AppBars
                ),


                )


        },

    ) { scaffoldPadding ->


        Column(
            modifier = androidx.compose.ui.Modifier
                .fillMaxSize()
                .padding(scaffoldPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize(1f),
                contentAlignment = Alignment.Center
            ) {

                Column(
                    modifier = androidx.compose.ui.Modifier
                        .fillMaxSize(1f),
                ) {

                    ShowDialogBox(viewModel = viewModel )


                    val context = LocalContext.current
                    val clickHereLink = context.resources.getString(R.string.click_here_link)
                    val bmrCalculatorScreenLink = context.resources.getString(R.string.bmr_calculator_screen_link)

                    AndroidView(factory = {
                        WebView(it).apply {
                            webViewClient = object: WebViewClient(){
                                override fun shouldOverrideUrlLoading(
                                    view: WebView?,
                                    request: WebResourceRequest?
                                ): Boolean {
                                    val myUrl = request?.url.toString()


                                    return when{
                                        myUrl.startsWith(bmrCalculatorScreenLink) -> {
                                            navController.navigate(ScreenRoutes.SecondScreenWebView.route)
                                            true

                                        }
                                        myUrl == clickHereLink -> {
                                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(myUrl))
                                            context.startActivity(intent)
                                            true
                                        }
                                        else -> false


                                    }

                                }


                            }

                            settings.javaScriptEnabled = true

                            loadUrl(url)

                            webView = this
                        }
                    }, update = {
                        it.loadUrl(url)
                    },
                        modifier = androidx.compose.ui.Modifier
                            .fillMaxSize(1f))

                }


            }

        }
    }
    }








