package com.example.tutorial_application.presentation.view.testpager.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.tutorial_application.presentation.viewmodel.testpager.FormViewModel

@Composable
fun PageAge(viewModel: FormViewModel) {
    TextField(
        value = viewModel.age.value,
//        ユーザーが文字を入力するとこのラムダ関数が呼ばれる
//        itは新しく入力された文字列
//        入力＞name.valueが変化>Composeが再コンポーズ>UI更新
        onValueChange = { viewModel.age.value = it },
        label = { Text("age") },
        modifier = Modifier.padding(16.dp)
    )
}