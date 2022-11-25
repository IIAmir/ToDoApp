package com.example.todoapp.domain.repository

import com.example.todoapp.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    fun getAllTasks(): Flow<List<ToDoTask>>

    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    suspend fun addTask(toDoTask: ToDoTask)

    suspend fun updateTask(toDoTask: ToDoTask)

    suspend fun deleteTask(toDoTask: ToDoTask)

    suspend fun deleteAllTasks()

    suspend fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>

    fun sortByLowPriority(): Flow<List<ToDoTask>>

    fun sortByHighPriority(): Flow<List<ToDoTask>>

}