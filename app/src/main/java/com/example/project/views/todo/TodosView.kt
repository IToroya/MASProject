package com.example.project.views.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun TodosView() {
    var todoTexts by remember {mutableStateOf(mutableListOf(
        "Kiss Dog",
        "Hug Wife",
        "Buy Butter and Bread",
        "Hold Hands with Wife"
    )
    )
    }
    var showModal: Boolean by remember { mutableStateOf(false)}
    val sheetState = rememberModalBottomSheetState()
    var newTodo: String by remember { mutableStateOf("")}

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 10.dp)
        ){
            HeaderWithButtonView("Todos") { showModal = true }
            todoTexts.forEach { todo ->
                Todo(
                    text = todo
                )
            }
            if (showModal) {
                ModalBottomSheet(
                    onDismissRequest = { showModal = false },
                    sheetState = sheetState
                )
                {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 10.dp)
                    )
                    {
                        HeaderWithButtonView("New Todo") {
                            todoTexts.add(newTodo)
                            newTodo = ""
                        }

                        OutlinedTextField(
                            modifier = Modifier
                                .fillMaxWidth(),
                            value = newTodo,
                            onValueChange = { newTodo = it },
                            label = { Text(text = "Todo")}
                        )
                    }
                }
            }
        }
    }
}