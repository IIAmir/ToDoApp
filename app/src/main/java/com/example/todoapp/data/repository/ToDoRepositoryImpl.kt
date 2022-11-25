package com.example.todoapp.data.repository

import com.example.todoapp.data.data_source.ToDoDao
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.domain.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepositoryImpl @Inject constructor(
    private val toDoDao: ToDoDao,
) : ToDoRepository {

    override fun getAllTasks(): Flow<List<ToDoTask>> {
        return toDoDao.getAllTasks()
    }

    override fun getSelectedTask(taskId: Int): Flow<ToDoTask> {
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    override suspend fun addTask(toDoTask: ToDoTask) {
        toDoDao.addTask(toDoTask = toDoTask)
    }

    override suspend fun updateTask(toDoTask: ToDoTask) {
        toDoDao.updateTask(toDoTask = toDoTask)
    }

    override suspend fun deleteTask(toDoTask: ToDoTask) {
        toDoDao.deleteTask(toDoTask = toDoTask)
    }

    override suspend fun deleteAllTasks() {
        toDoDao.deleteAllTask()
    }

    override suspend fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }

    override fun sortByLowPriority(): Flow<List<ToDoTask>> {
        return toDoDao.sortByLowPriority()
    }

    override fun sortByHighPriority(): Flow<List<ToDoTask>> {
        return toDoDao.sortByHighPriority()
    }

}