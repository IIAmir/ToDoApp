package com.example.todoapp.ui.screens.task.components

import androidx.compose.runtime.Composable
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.util.Action

@Composable
fun TaskAppBar(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
) {
    if (selectedTask == null) {
        NewTaskAppBar(
            navigateToListScreen = navigateToListScreen
        )
    } else {
        ExistingTaskAppBar(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen
        )
    }
}