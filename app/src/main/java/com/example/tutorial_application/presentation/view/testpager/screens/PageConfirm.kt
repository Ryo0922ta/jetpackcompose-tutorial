package com.example.tutorial_application.presentation.view.testpager.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorial_application.presentation.viewmodel.testpager.FormViewModel

@Composable
fun PageConfirm(viewModel: FormViewModel){
    Column (modifier = Modifier.padding(16.dp)){
        Text("name:${viewModel.name.value}")
        Text("age:${viewModel.age.value}")
    }
}