package com.example.todoapp.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.models.ToDoTask

@Database(entities = [ToDoTask::class], version = 1, exportSchema = false)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun toDoDao(): ToDoDao

}