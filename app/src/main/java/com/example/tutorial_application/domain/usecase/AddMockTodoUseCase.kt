package com.example.tutorial_application.domain.usecase

import com.example.tutorial_application.domain.model.TodoItem
import com.example.tutorial_application.domain.repository.TodoRepository
import javax.inject.Inject

class AddMockTodoUseCase @Inject constructor(
    private val todoRepository: TodoRepository
) {
    suspend operator fun invoke(title: String): TodoItem {
        return todoRepository.addTodo(title)
    }
}