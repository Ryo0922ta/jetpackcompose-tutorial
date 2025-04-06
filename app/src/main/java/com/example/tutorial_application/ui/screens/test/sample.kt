package com.example.tutorial_application.ui.screens.test

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tutorial_application.ui.theme.Tutorial_applicationTheme

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello test $name!",
        modifier = modifier
    )
}

@Composable
fun SampleApp(modifier: Modifier = Modifier) {

    var isShowAlert by remember {
        mutableStateOf(false)
    }

    Column(
        verticalArrangement = Arrangement.Center, //縦方向の中央揃え
        horizontalAlignment = Alignment.CenterHorizontally,//横方向の中央揃え
        modifier = modifier.fillMaxSize()
    ) {
        Greeting(name = "test")

        Button(
            onClick = {
                isShowAlert = true
            }
        ) {
            Text(text = "Press Me!")
        }

        Greeting(name = "test")

        if (isShowAlert) {
            SampleAlertDialog { isShowAlert = false }
        }

    }
}

@Composable
fun SampleAlertDialog(onDismissClicked: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismissClicked,
        title = {
            Text(text = "sample Alert")
        },
        confirmButton = { /*TODO*/ },
        dismissButton = {
            TextButton(onClick = onDismissClicked) {
                Text(text = "Dismiss")
            }
        }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    Tutorial_applicationTheme {
        SampleApp()
    }
}