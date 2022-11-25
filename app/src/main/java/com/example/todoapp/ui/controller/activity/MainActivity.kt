package com.example.todoapp.ui.controller.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavHostController
import com.example.todoapp.ui.controller.navigation.Navigation
import com.example.todoapp.ui.screens.viewmodel.SharedViewModel
import com.example.todoapp.ui.theme.ToDoAppTheme
import com.example.todoapp.ui.theme.taskItemBackgroundColor
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController
    private val sharedViewModel: SharedViewModel by viewModels()

    @OptIn(ExperimentalAnimationApi::class, ExperimentalMaterialApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ToDoAppTheme {
                Surface(contentColor = MaterialTheme.colors.taskItemBackgroundColor,
                    color = MaterialTheme.colors.taskItemBackgroundColor) {
                    navHostController = rememberAnimatedNavController()
                    Navigation(
                        navHostController = navHostController,
                        sharedViewModel = sharedViewModel
                    )
                }
            }
        }
    }
}