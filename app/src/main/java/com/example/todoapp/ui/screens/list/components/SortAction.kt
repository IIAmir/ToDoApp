package com.example.todoapp.ui.screens.list.components

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Constants

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    IconButton(onClick = { expanded = true }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter_list),
            contentDescription = Constants.SORT_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor)

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            Priority.values().slice(setOf(0, 2, 3)).forEach { priority ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onSortClicked(priority)
                }) {
                    PriorityItem(priority = priority)
                }
            }
        }
    }
}