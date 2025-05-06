package com.example.tutorial_application.repository

import com.example.tutorial_application.data.TodoItem
import javax.inject.Inject

//inject:日本語で注射である。つまり依存性の注入をここで示している
class MockTodoRepositoryImpl @Inject constructor() : TodoRepository {
    private val todoList = mutableListOf(
        TodoItem(1, "test", false)
    )

    override suspend fun getTodo() = todoList

    override suspend fun addTodo(title: String): TodoItem {
        val newTodoItem = TodoItem(todoList.size + 1, title, false)
        todoList.add(newTodoItem)
        return newTodoItem
    }
}