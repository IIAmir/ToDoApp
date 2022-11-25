package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.data_source.ToDoDao
import com.example.todoapp.data.data_source.ToDoDatabase
import com.example.todoapp.data.repository.ToDoRepositoryImpl
import com.example.todoapp.domain.repository.ToDoRepository
import com.example.todoapp.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideToDoRepository(
        toDoDao: ToDoDao
    ): ToDoRepository {
        return ToDoRepositoryImpl(toDoDao)
    }

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideDao(database: ToDoDatabase) = database.toDoDao()

}