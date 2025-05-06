package com.example.tutorial_application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application()

//hiltが依存性コンテナをアプリ全体に用意するために必要
//Applicationはandroid開発で最も上位のコンポーネント。
//hiltがアプリ全体を管理するためにはこの段階で初期化される必要がある