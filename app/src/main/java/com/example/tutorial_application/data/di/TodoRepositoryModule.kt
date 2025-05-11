package com.example.tutorial_application.data.di

import com.example.tutorial_application.data.repositoryimpl.MockTodoRepositoryImpl
import com.example.tutorial_application.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

//モジュールは事前に必要な部品を用意しておく場所
//@Module:このクラスは依存性の提供をする場所であるということをhiltに明示
//@InstallIn(SingletonComponent::class):ここはアプリ全体で共通で使用されることを明示
@Module
@InstallIn(SingletonComponent::class)
object TodoRepositoryModule {

    //@Provides：実際に依存性を作る関数であることを明示
//@Singleton：アプリ起動時に１つだけ作られて使い回しされること明示
    @Provides
    @Singleton
    fun provideTodoRepository(): TodoRepository {
        return MockTodoRepositoryImpl()
    }
//  ここの記述で必要とされている型に対してどのクラスを返すかを決定している
}