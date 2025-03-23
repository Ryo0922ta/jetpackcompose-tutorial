package com.example.tutorial_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.tutorial_application.ui.screens.test.TestFunc
import com.example.tutorial_application.ui.theme.Tutorial_applicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tutorial_applicationTheme {
//              innerPaddingにScaffoldが考慮した。ステータスバーなどの余白情報が入る
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
//                            .fillMaxSize()//親要素に合わせて最大サイズに広げる
                            .padding(innerPadding),//boxコンポーネントにpadding情報を与える
//                        contentAlignment = Alignment.Center
                    ) {
//                        SampleApp()
                        TestFunc("test")
                    }
                }
            }
        }
    }
}
