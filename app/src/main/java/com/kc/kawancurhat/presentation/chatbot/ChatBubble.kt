package com.kc.kawancurhat.presentation.chatbot

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

@Composable
fun ChatBubble(
    modifier: Modifier = Modifier,
    text: String,
    isUser: Boolean
) {
    Box(
        modifier = modifier
            .drawBehind {
                drawRoundRect(
                    if (isUser) {
                        Color(0xFF30B5FF)
                    } else {
                        Color(0xFFFFFFFF)
                    },
                    cornerRadius = CornerRadius(10.dp.toPx()),
                )
            }
            .padding(8.dp)
    ) {
        Text(text = text, color = if(isUser) Color.White else Color.Black)
    }
}

@Composable
@Preview(showBackground = true)
fun ChatBubblePreview() {
    KawanCurhatTheme {
        ChatBubble(
            isUser = true,
            text = "Halo, selamat pagi, siang, malam"
        )
    }
}
