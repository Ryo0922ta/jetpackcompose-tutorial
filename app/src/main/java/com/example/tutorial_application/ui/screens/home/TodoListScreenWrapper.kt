package com.example.tutorial_application.ui.screens.home

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tutorial_application.viewmodel.TodoViewModel

@Composable
fun TodoListScreenWrapper() {
    val viewModel: TodoViewModel = hiltViewModel()
    MyHomeScreenWidget(viewModel)
}