package com.example.tutorial_application.domain.usecase

import com.example.tutorial_application.domain.model.TodoItem
import com.example.tutorial_application.domain.repository.TodoRepository
import javax.inject.Inject

class GetMockTodoUseCase @Inject constructor(
    private var todoRepository: TodoRepository
) {
    suspend operator fun invoke(): List<TodoItem> {
        return todoRepository.getTodo()
    }
}