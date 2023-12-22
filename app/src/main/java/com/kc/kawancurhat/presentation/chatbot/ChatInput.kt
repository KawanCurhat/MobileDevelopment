package com.kc.kawancurhat.presentation.chatbot

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp

@Composable
fun ChatInput(
    modifier: Modifier = Modifier
) {
    var inputVal by remember { mutableStateOf("") }

    fun sendMsg() {
        inputVal = ""
    }

    Row {
        TextField(
            modifier = Modifier.weight(1f),
            value = inputVal,
            onValueChange = {inputVal = it},
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Send),
            keyboardActions = KeyboardActions{ sendMsg() }
        )
        Button(
            modifier = Modifier.size(56.dp),
            onClick = { sendMsg() },
            enabled = inputVal.isNotBlank()
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Send,
                contentDescription = "Send"
            )
        }
    }
}