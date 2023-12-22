package com.kc.kawancurhat.presentation.chatbot

import android.graphics.Paint.Align
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(8.dp),
    ) {
        ChatBubble(text = "Hello World", isUser = true, modifier = Modifier.align(Alignment.End))
        ChatBubble(text = "Ada yang bisa dibantu?", isUser = false)
    }
}

@Composable
@Preview(showBackground = true)
fun ChatScreenPrev() {
    KawanCurhatTheme {
        ChatScreen()
    }
}
