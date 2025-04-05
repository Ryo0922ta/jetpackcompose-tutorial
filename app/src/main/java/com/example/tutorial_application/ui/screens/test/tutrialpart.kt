package com.example.tutorial_application.ui.screens.test

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tutorial_application.ui.theme.Tutorial_applicationTheme

@Composable
fun TestFunc(name: String, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.padding(24.dp)
        )
    {
        Text(
            text = "Hello Test Func $name!",
            modifier = modifier
                .background(Color.Red)
                .padding(24.dp)

        )
    }
}

@Composable
fun MyTutrialApp(modifier: Modifier = Modifier) {
    Surface(
        color = Color.LightGray,
        modifier = modifier.padding(24.dp)
    ) {
        TestFunc("android develop");
    }
}

@Composable
fun MyTutrialApp2(modifier: Modifier = Modifier) {
    Surface(color = Color.Blue) {
        MyTutrialApp();
    }
}

//modifier　見た目や振る舞いを変更するためのオブジェクト
//UIの定義でパラメータとして渡してあげることでこの関数の呼び出し元でもレイアウトや装飾をカスタムできる
@Preview
//    showBackground = true,
//    showSystemUi = true

@Composable
fun TestPreview() {
    Tutorial_applicationTheme {
//        TestFunc("tutrial")
//        MyTutrialApp();
          MyTutrialApp2();
    }
}