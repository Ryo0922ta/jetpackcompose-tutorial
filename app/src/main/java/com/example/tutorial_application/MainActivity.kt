package com.example.tutorial_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.tutorial_application.ui.screens.home.TodoListScreenWrapper
import com.example.tutorial_application.ui.screens.test.MyTutrialApp
import com.example.tutorial_application.ui.theme.Tutorial_applicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TodoListScreenWrapper()
//            Tutorial_applicationTheme {
////                        SampleApp()
//                MyTutrialApp();
//            }
        }
    }
}
