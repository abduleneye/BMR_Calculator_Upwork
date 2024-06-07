package com.bmrcalculator.bmrcalculator.app_features.presentation

import android.webkit.JavascriptInterface
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
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
import java.lang.reflect.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FirstScreenWebView(
    url: String,
    navController: NavController,

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

            //AppRatingDialogBox()

            fun injectJavaScript(webView: WebView, script: String){

                webView.evaluateJavascript(script, null)


            }

            Box(
                modifier = androidx.compose.ui.Modifier
                    .fillMaxSize(1f),
                contentAlignment = Alignment.Center
            ) {

                val context = LocalContext.current

                AndroidView(factory = {
                    //id = "myButton"
                    WebView(it).apply {
                        webViewClient = object: WebViewClient(){
                            override fun shouldOverrideUrlLoading(
                                view: WebView?,
                                request: WebResourceRequest?
                            ): Boolean {

                                val url = request?.url.toString()
                                return if (url.startsWith("action://start_second_activity")){
                                  //  Toast.makeText(context, "Alhamdullilah", Toast.LENGTH_SHORT).show()
                                    navController.navigate(ScreenRoutes.SecondScreenWebView.route)
                                    true

                                }else{
                                    false
                                }
                            }
                        }

                        settings.javaScriptEnabled = true
//                        settings.loadsImagesAutomatically = true
//                        settings.useWideViewPort = true
//                        settings.setSupportZoom(true)

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








