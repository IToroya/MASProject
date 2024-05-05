package com.example.project.views.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true)
@Composable
fun TodosView() {
    val todoTexts = listOf(
        "Kiss Dog",
        "Hug Wife",
        "Buy Butter and Bread",
        "Hold Hands with Wife"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Todos",
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight.Bold)
            todoTexts.forEach{ todo ->
                Todo(
                    text = todo,
                )
            }
        }
    }
}