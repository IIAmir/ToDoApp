package com.example.todoapp.ui.screens.list.components

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import com.example.todoapp.ui.theme.topAppBarContentColor
import com.example.todoapp.util.Constants

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit,
) {
    IconButton(onClick = { onSearchClicked() }) {
        Icon(imageVector = Icons.Filled.Search,
            contentDescription = Constants.SEARCH_BUTTON,
            tint = MaterialTheme.colors.topAppBarContentColor)
    }
}