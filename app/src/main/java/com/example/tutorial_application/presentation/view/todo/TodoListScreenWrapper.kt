package com.example.tutorial_application.presentation.view.todo

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.tutorial_application.MyHomeScreenWidget
import com.example.tutorial_application.presentation.viewmodel.TodoViewModel

@Composable
fun TodoListScreenWrapper() {
    val viewModel: TodoViewModel = hiltViewModel()
    MyHomeScreenWidget(viewModel)
}