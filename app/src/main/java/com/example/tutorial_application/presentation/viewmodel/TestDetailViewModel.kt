package com.example.tutorial_application.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tutorial_application.domain.model.TestCreateUser

class TestDetailViewModel : ViewModel() {
    private val _user = mutableStateOf<TestCreateUser?>(null)//内部用の変数宣言
    val user: State<TestCreateUser?> = _user//外部公開用の読み取り専用の変数宣言

    fun setUser(user: TestCreateUser) {
        _user.value = user
    }
}