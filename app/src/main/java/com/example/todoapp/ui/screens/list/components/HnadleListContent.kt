package com.example.todoapp.ui.screens.list.components

import androidx.compose.runtime.Composable
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.util.Action

@Composable
fun HandleListContent(
    toDoTasks: List<ToDoTask>,
    onSwipeToDelete: (Action, ToDoTask) -> Unit,
    navigateToTaskScreen: (taskId: Int) -> Unit,
) {
    if (toDoTasks.isEmpty()) {
        EmptyContent()
    } else {
        TaskList(
            toDoTask = toDoTasks,
            onSwipeToDelete = onSwipeToDelete,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}