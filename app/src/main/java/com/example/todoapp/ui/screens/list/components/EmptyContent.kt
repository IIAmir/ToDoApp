package com.example.todoapp.ui.screens.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import com.example.todoapp.R
import com.example.todoapp.ui.theme.EMPTY_CONTENT_ICON_SIZE
import com.example.todoapp.ui.theme.MediumGray
import com.example.todoapp.util.Constants.EMPTY_DATABASE
import com.example.todoapp.util.Constants.SAD_FACE_ICON

@Composable
fun EmptyContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(EMPTY_CONTENT_ICON_SIZE),
            painter = painterResource(id = R.drawable.ic_baseline_sentiment),
            contentDescription = SAD_FACE_ICON,
            tint = MediumGray
        )
        Text(
            text = EMPTY_DATABASE,
            color = MediumGray,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h6.fontSize
        )
    }
}