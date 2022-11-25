package com.example.todoapp.util

fun String?.toAction(): Action {
    return if (this.isNullOrEmpty())
        Action.NO_ACTION
    else
        Action.valueOf(this)
}