package com.example.project.views.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.project.views.login.LoginView
import com.example.project.views.todo.TodosView

enum class Destinations(val rawValue: String) {
    LOGIN_VIEW(rawValue = "loginview"),
    TODOS_VIEW(rawValue = "todosview")
}

@Preview(showBackground = true)
@Composable
fun ContentView() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHost(navController = navController, startDestination = Destinations.LOGIN_VIEW.rawValue) {
            composable(Destinations.LOGIN_VIEW.rawValue) {
                LoginView(navController)
            }

            composable(Destinations.TODOS_VIEW.rawValue) {
                TodosView()
            }
        }
    }
}