package com.example.todoapp.ui.screens.task.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants.ADD_TASK_BUTTON

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit,
) {
    IconButton(onClick = {
        onAddClicked(Action.ADD)
    }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = ADD_TASK_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}