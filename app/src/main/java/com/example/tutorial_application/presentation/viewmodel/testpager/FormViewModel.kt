package com.example.tutorial_application.presentation.viewmodel.testpager

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

//クラス宣言の:ViewModel()は継承元
class FormViewModel : ViewModel() {
    var name = mutableStateOf("")
    var age = mutableStateOf("")
}