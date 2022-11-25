package com.example.todoapp.ui.screens.task.components

import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import com.example.todoapp.R
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.screens.list.components.DisplayAlertDialog
import com.example.todoapp.util.Action

@Composable
fun ExistingTaskAppBarActions(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit,
) {
    var openDialog by remember {
        mutableStateOf(false)
    }

    DisplayAlertDialog(
        title = stringResource(
            id = R.string.delete_task,
            selectedTask.title
        ),
        message = stringResource(
            id = R.string.delete_task_confirmation,
            selectedTask.title
        ),
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = {
            navigateToListScreen(Action.DELETE)
        }
    )
    DeleteAction(onDeleteClicked = {
        openDialog = true
    })
    UpdateAction(onUpdateClicked = navigateToListScreen)
}