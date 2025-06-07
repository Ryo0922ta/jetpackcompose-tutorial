package com.example.tutorial_application.presentation.view.testui.screens.test


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tutorial_application.domain.model.TestCreateUser
import com.example.tutorial_application.presentation.viewmodel.TestDetailViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestScreen1(
    navController: NavController,
    viewModel: TestDetailViewModel
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("画面1") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp)
        ) {

            Button(onClick = {
                val user = TestCreateUser(userid = 1000, name = "田中太郎じゃない？")
                viewModel.setUser(user)
                navController.navigate("screen2")
            }) {
                Text("画面2へ遷移")
            }
        }
    }
}
