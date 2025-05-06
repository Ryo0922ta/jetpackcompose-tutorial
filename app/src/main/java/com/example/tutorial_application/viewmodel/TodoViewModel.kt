package com.example.tutorial_application.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tutorial_application.data.TodoItem
import com.example.tutorial_application.repository.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel:hiltにこのviewModelに依存性を注入することを伝える
@HiltViewModel
class TodoViewModel @Inject constructor(
    private val repository: TodoRepository
) : ViewModel() {
    //  _todosの「 _ 」:プライベート変数につける印。内部のみで利用する変数につける
    private val _todos = mutableStateOf<List<TodoItem>>(emptyList())

    //  以下の宣言は外部からの読み取り専用変数を定義している
    val todos: State<List<TodoItem>> = _todos

    private val _text = mutableStateOf("")
    val text: State<String> = _text

    init {
//       非同期でリポジトリからデータを取得
        viewModelScope.launch {
            _todos.value = repository.getTodo()
        }
    }

    fun onTextChange(newText: String) {
        _text.value = newText
    }

    fun addTodo() {
        val title = _text.value.trim()
        if (title.isNotEmpty()) {
            viewModelScope.launch {
                repository.addTodo(title)
                _todos.value = repository.getTodo()
                _text.value = ""
            }

        }
    }

    fun toggleTodo(index: Int) {
        val currentList = _todos.value.toMutableList()
//      isDoneの値のみ更新され他の値はそのままコピーされる
        val update = currentList[index].copy(isDone = !currentList[index].isDone)
        currentList[index] = update
        _todos.value = currentList
    }

}