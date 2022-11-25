package com.example.todoapp.ui.screens.task.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Constants.DELETE_BUTTON

@Composable
fun DeleteAction(
    onDeleteClicked: () -> Unit,
) {
    IconButton(onClick = {
        onDeleteClicked()
    }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = DELETE_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}