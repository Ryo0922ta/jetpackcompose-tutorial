package com.example.tutorial_application

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
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
                        SampleApp()

                    }
                }
            }
        }
    }
}

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
        Greeting(name="test")

        Button(
            onClick = {
                isShowAlert = true
            }
        ) {
            Text(text = "Press Me!")
        }

        Greeting(name="test")

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