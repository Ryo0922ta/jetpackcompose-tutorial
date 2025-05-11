package com.example.tutorial_application.domain.repository

import com.example.tutorial_application.domain.model.TodoItem

interface TodoRepository {
    suspend fun getTodo(): List<TodoItem>
    suspend fun addTodo(title: String): TodoItem
}