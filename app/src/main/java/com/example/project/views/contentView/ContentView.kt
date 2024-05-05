package com.example.project.views.contentView

import android.text.TextUtils
import android.util.Patterns
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project.errors.loginErrors.ErrorMessages
import com.example.project.extensions.isValidEmail
import com.example.project.extensions.isValidPassword


@Preview(showBackground = true)
@Composable
fun ContentView() {
    var emailInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }
    var loginEnabled: Boolean by remember { mutableStateOf(false) }
    var showEmailErrorMessage: Boolean by remember { mutableStateOf(false) }
    var inputsAreValid: Boolean by remember { mutableStateOf(false) }
    var showPasswordErrorMessage: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            if (showEmailErrorMessage) {
                Text(
                    text = ErrorMessages.EMAIL_ERROR_MESSAGE.rawValue,
                    color = Color.Red
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = emailInput,
                    onValueChange = {
                        emailInput = it
                        showEmailErrorMessage = false
                    },
                    label = { Text("Email") }
                )
            } else {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = emailInput,
                    onValueChange = {
                        emailInput = it
                        showEmailErrorMessage = false
                    },
                    label = { Text("Email") }
                )
            }

            if (showPasswordErrorMessage) {
                Text(
                    modifier = Modifier.alpha(if (showPasswordErrorMessage) 1f else 0f),
                    text = ErrorMessages.PASSWORD_ERROR_MESSAGE.rawValue,
                    color = Color.Red
                )
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = passwordInput,
                    onValueChange = {
                        passwordInput = it
                        loginEnabled = passwordInput.isNotBlank() && emailInput.isNotBlank()
                        showPasswordErrorMessage = false
                    },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation()
                )
            } else {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = passwordInput,
                    onValueChange = {
                        passwordInput = it
                        loginEnabled = passwordInput.isNotBlank() && emailInput.isNotBlank()
                        showPasswordErrorMessage = false
                    },
                    label = { Text("Password") },
                    visualTransformation = PasswordVisualTransformation()
                )
            }

            ElevatedButton(
                modifier = Modifier
                    .fillMaxWidth(),
                enabled = loginEnabled,
                onClick = {
                    showEmailErrorMessage = !emailInput.isValidEmail()
                    showPasswordErrorMessage = !passwordInput.isValidPassword()
                    inputsAreValid = passwordInput.isValidPassword() && emailInput.isValidEmail()
                }
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}