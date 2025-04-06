package com.example.tutorial_application.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyHomeScreenWidget() {

    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { innerPadding ->
        ToDoListView(innerPadding)
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopAppBar() {
    TopAppBar(
        title = {
            Text(
                text = "home",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        },
    )
}

@Composable
fun ToDoListView(paddingValues: PaddingValues) {
    val todoList = remember { mutableStateListOf<String>() }
    var text by remember { mutableStateOf("") }
    val checkedStates = remember { mutableStateListOf<Boolean>() }

    Column(modifier = Modifier.padding(paddingValues)) {
        //weight(1f) : 親のコンテナ内で 残りのスペースを1:1の比率で占める
        LazyColumn(modifier = Modifier.weight(1f)) {
            items(todoList.size) { index ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedStates[index],
                        onCheckedChange = { checkedStates[index] = it }
                    )
                    Text(
                        text = todoList[index],
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("TODO") },
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)
            )
            Button(
                onClick = {
                    if (text.isEmpty()) return@Button
                    todoList.add(text)
                    checkedStates.add(false)
                    text = ""
                },
                modifier = Modifier.height(64.dp)
                //form欄とボタンの縦幅が同じで見え方にズレがないため今回はalignは不要
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp
                )
            }
        }
    }


}


@Preview(device = Devices.PIXEL_7)
@Composable
fun MyHomeScreenViewPreview() {
    MyHomeScreenWidget()
}