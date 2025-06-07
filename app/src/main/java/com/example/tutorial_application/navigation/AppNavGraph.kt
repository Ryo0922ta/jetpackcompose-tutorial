package com.example.tutorial_application.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tutorial_application.presentation.view.testui.screens.test.Screen2
import com.example.tutorial_application.presentation.view.testui.screens.test.TestModal
import com.example.tutorial_application.presentation.viewmodel.TestDetailViewModel

@Composable
fun AppNavGraph(navController: NavHostController) {
    val testDetailViewModel = viewModel<TestDetailViewModel>()

    NavHost(navController = navController, startDestination = "ModalTestScreen") {
        composable("ModalTestScreen") {
            TestModal(navController, testDetailViewModel)
        }
        composable("screen2") {
            Screen2(testDetailViewModel)
        }
    }
}