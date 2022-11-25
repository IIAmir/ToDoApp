package com.example.todoapp.ui.screens.task.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.todoapp.data.models.Priority
import com.example.todoapp.ui.theme.LARGE_PADDING
import com.example.todoapp.ui.theme.MEDIUM_PADDING
import com.example.todoapp.util.Constants.DESCRIPTION_TEXT_FIELD
import com.example.todoapp.util.Constants.MAX_TITLE_LENGTH
import com.example.todoapp.util.Constants.TITLE_TEXT_FIELD

@Composable
fun TaskContent(
    title: String,
    onTitleChange: (String) -> Unit,
    description: String,
    onDescriptionChange: (String) -> Unit,
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit,
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colors.background)
        .padding(all = LARGE_PADDING)
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = title,
            onValueChange = { onTitleChange(it) },
            label = { Text(text = TITLE_TEXT_FIELD) },
            textStyle = MaterialTheme.typography.body1,
            singleLine = true,
            maxLines = MAX_TITLE_LENGTH
        )

        Spacer(
            modifier = Modifier.height(MEDIUM_PADDING)
        )

        PriorityDropDown(
            priority = priority,
            onPrioritySelected = onPrioritySelected
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxSize(),
            value = description,
            onValueChange = { onDescriptionChange(it) },
            label = { Text(text = DESCRIPTION_TEXT_FIELD) },
            textStyle = MaterialTheme.typography.body1
        )
    }
}