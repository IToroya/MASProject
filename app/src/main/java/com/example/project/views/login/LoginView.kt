package com.example.project.views.login

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.project.errors.loginErrors.ErrorMessages
import com.example.project.extensions.isValidEmail
import com.example.project.extensions.isValidPassword
import com.example.project.views.content.Destinations

@Composable
fun LoginView(navController: NavHostController) {
    var emailInput: String by remember { mutableStateOf("") }
    var passwordInput: String by remember { mutableStateOf("") }
    var loginEnabled: Boolean by remember { mutableStateOf(false) }
    var showEmailErrorMessage: Boolean by remember { mutableStateOf(false) }
    var inputsAreValid: Boolean by remember { mutableStateOf(false) }
    var showPasswordErrorMessage: Boolean by remember { mutableStateOf(false) }
    var showProgressBar: Boolean by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {

        if (!showProgressBar) {

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

                    if (inputsAreValid)  {
                        showProgressBar = true
                        Handler(Looper.getMainLooper()).postDelayed({
                            navController.navigate(Destinations.TODOS_VIEW.rawValue)
                        }, 3000)
                    } else {
                        showProgressBar = true
                        Handler(Looper.getMainLooper()).postDelayed({
                            showProgressBar = false
                        }, 3000)
                    }
                }
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }

        } else {
            Column {
                LinearProgressIndicator(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                )
            }
        }
    }
}
