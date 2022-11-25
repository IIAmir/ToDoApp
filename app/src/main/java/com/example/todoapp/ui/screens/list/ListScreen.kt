package com.example.todoapp.ui.screens.list

import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.todoapp.data.models.Priority
import com.example.todoapp.data.models.ToDoTask
import com.example.todoapp.ui.screens.list.components.DisplaySnackBar
import com.example.todoapp.ui.screens.list.components.ListAppBar
import com.example.todoapp.ui.screens.list.components.ListContent
import com.example.todoapp.ui.screens.list.components.ListFab
import com.example.todoapp.ui.screens.viewmodel.SharedViewModel
import com.example.todoapp.util.Action
import com.example.todoapp.util.RequestState
import com.example.todoapp.util.SearchAppBarState

@Composable
fun ListScreen(
    action: Action,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedViewModel: SharedViewModel,
) {

    LaunchedEffect(key1 = action) {
        sharedViewModel.handleDatabaseActions(action)
    }

    val allTasks: RequestState<List<ToDoTask>>
            by sharedViewModel.allTasks.collectAsState()
    val searchTasks: RequestState<List<ToDoTask>>
            by sharedViewModel.searchTasks.collectAsState()
    val searchAppBarState: SearchAppBarState
            by sharedViewModel.searchAppBarState
    val searchTextState: String
            by sharedViewModel.searchTextState
    val sortState: RequestState<Priority>
            by sharedViewModel.sortState.collectAsState()
    val lowPriorityTasks: List<ToDoTask>
            by sharedViewModel.lowPriorityTasks.collectAsState()
    val highPriorityTasks: List<ToDoTask>
            by sharedViewModel.highPriorityTasks.collectAsState()

    val scaffoldState = rememberScaffoldState()

    DisplaySnackBar(
        scaffoldState = scaffoldState,
        onComplete = { sharedViewModel.action.value = it },
        onUndoClicked = {
            sharedViewModel.action.value = it
        },
        taskTitle = sharedViewModel.title.value,
        action = action
    )

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            ListAppBar(
                sharedViewModel = sharedViewModel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = {
            ListContent(
                toDoTask = allTasks,
                searchTasks = searchTasks,
                lowPriorityTasks = lowPriorityTasks,
                highPriorityTasks = highPriorityTasks,
                sortState = sortState,
                searchAppBarState = searchAppBarState,
                onSwipeToDelete = { action, task ->
                    sharedViewModel.action.value = action
                    sharedViewModel.updateTaskFields(selectedTask = task)
                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                },
                navigateToTaskScreen = navigateToTaskScreen
            )
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
}