package com.example.project.views.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Todo(text: String) {
    var showFilled: Boolean by remember { mutableStateOf(false) }
    Row {
        IconButton(onClick = {showFilled = showFilled.not()}) {
            Icon(if (showFilled) Icons.Outlined.Favorite else Icons.Outlined.FavoriteBorder, "Heartshaped Icon")
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
            text = text)
    }
}

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