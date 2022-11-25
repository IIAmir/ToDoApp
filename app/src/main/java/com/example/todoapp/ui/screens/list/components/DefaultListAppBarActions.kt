package com.example.todoapp.ui.screens.list.components

import androidx.compose.runtime.*
import com.example.todoapp.data.models.Priority
import com.example.todoapp.util.Constants

@Composable
fun DefaultListAppBarActions(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteAllConfirmed: () -> Unit,
) {
    var openDialog by remember {
        mutableStateOf(false)
    }

    DisplayAlertDialog(
        title = Constants.DELETE_ALL_TASKS,
        message = Constants.DELETE_ALL_TASKS_CONFIRMATION,
        openDialog = openDialog,
        closeDialog = { openDialog = false },
        onYesClicked = {
            onDeleteAllConfirmed()
        }
    )

    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllAction { openDialog = true }
}