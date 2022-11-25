package com.example.todoapp.ui.screens.task.components

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarBackgroundColor
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Action
import com.example.todoapp.util.Constants.ADD_TASK_SCREEN_TITLE

@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = ADD_TASK_SCREEN_TITLE,
                color = MaterialTheme.colors.topAppBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.topAppBarBackgroundColor,
        actions = {
            AddAction(onAddClicked = navigateToListScreen)
        }
    )
}