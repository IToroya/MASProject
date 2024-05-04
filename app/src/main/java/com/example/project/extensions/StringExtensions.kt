package com.example.project.extensions

import android.text.TextUtils
import android.util.Patterns

fun String.isValidEmail() =
    !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()

fun String.isValidPassword() =
    !TextUtils.isEmpty(this) && this.length == 6 && this.toIntOrNull() != null