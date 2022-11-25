package com.example.todoapp.ui.screens.list.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.todoapp.R
import com.example.todoapp.ui.theme.LARGE_PADDING
import com.example.todoapp.ui.theme.Typography
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Constants

@Composable
fun DeleteAllAction(
    onDeleteAllConfirmed: () -> Unit,
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    IconButton(onClick = { expanded = true }) {

        Icon(
            painter = painterResource(id = R.drawable.ic__more_vert),
            contentDescription = Constants.DELETE_ALL_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor)

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }) {
            DropdownMenuItem(onClick = {
                expanded = false
                onDeleteAllConfirmed()
            }) {
                Text(
                    modifier = Modifier.padding(start = LARGE_PADDING),
                    text = Constants.DELETE_ALL_ACTION,
                    style = Typography.subtitle2)
            }
        }
    }
}