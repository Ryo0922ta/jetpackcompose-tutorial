package com.example.tutorial_application

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tutorial_application.domain.model.TodoItem
import com.example.tutorial_application.presentation.viewmodel.TodoViewModel

@Composable
fun MyHomeScreenWidget(viewModel: TodoViewModel) {
    val todos by viewModel.todos
    val text by viewModel.text

    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { innerPadding ->
        ToDoListView(
            paddingValues = innerPadding,
            todos = todos,
            text = text,
            onTextChange = viewModel::onTextChange,
            onAddTodo = viewModel::addTodo,
            onToggleTodo = viewModel::toggleTodo
        )
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
fun ToDoListView(
    paddingValues: PaddingValues,
    todos: List<TodoItem>,
    text: String,
    onTextChange: (String) -> Unit,
    onAddTodo: () -> Unit,
    onToggleTodo: (Int) -> Unit
) {


    Column(modifier = Modifier.padding(paddingValues)) {
        //weight(1f) : 親のコンテナ内で 残りのスペースを1:1の比率で占める
        LazyColumn(modifier = Modifier.weight(1f)) {
            itemsIndexed(todos) { index, item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = item.isDone,
                        onCheckedChange = { onToggleTodo(index) }
                    )
                    Text(
                        text = item.title,
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
                onValueChange = onTextChange,
                label = { Text("TODO") },
                modifier = Modifier
                    .wrapContentHeight()
                    .weight(1f)
            )
            Button(
                onClick = onAddTodo,
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

@Composable
fun HyHomeScreenViewWidgetPreview() {
    Scaffold(
        topBar = {
            HomeTopAppBar()
        }
    ) { innerPadding ->
        ToDoListView(
            paddingValues = innerPadding,
            todos = listOf(
                TodoItem(id = 1, title = "買い物へ行く", isDone = false),
                TodoItem(id = 2, title = "宿題をする", isDone = true)
            ),
            text = "本を読む",
            onTextChange = {},
            onAddTodo = {},
            onToggleTodo = {}
        )
    }
}

@Preview(device = Devices.PIXEL_7)
@Composable
fun MyHomeScreenViewPreview() {
    HyHomeScreenViewWidgetPreview()
}