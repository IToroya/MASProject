package com.example.project.views.contentView

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Todo(title: String) {
    Text(
        modifier = Modifier.padding(5.dp),
        text = title
    )
}

@Preview(showBackground = true)
@Composable
fun TodosView() {
    val todos = listOf(
        "Kiss my dog",
        "Buy bread",
        "Buy Butter",
        "Lock the door",
        "Vacuum the living room"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        todos.forEach{todo -> Todo(todo)}
    }
}