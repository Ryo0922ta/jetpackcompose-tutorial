package com.example.tutorial_application.repository

import com.example.tutorial_application.data.TodoItem

interface TodoRepository {
    suspend fun getTodo(): List<TodoItem>
    suspend fun addTodo(title: String): TodoItem
}