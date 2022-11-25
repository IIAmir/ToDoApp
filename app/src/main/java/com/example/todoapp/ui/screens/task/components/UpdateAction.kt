package com.example.todoapp.ui.screens.task.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants.UPDATE_BUTTON

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit,
) {
    IconButton(onClick = {
        onUpdateClicked(Action.UPDATE)
    }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = UPDATE_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor
        )
    }
}