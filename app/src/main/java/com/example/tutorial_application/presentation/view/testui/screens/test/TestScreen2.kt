package com.example.tutorial_application.presentation.view.testui.screens.test

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorial_application.presentation.viewmodel.TestDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(viewModel: TestDetailViewModel) {
    val user = viewModel.user.value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("画面2") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Text("受け取ったユーザー情報：")
            Text("ID: ${user?.userid}")
            Text("名前: ${user?.name}")
        }
    }
}
