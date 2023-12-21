package com.kc.kawancurhat.presentation.home_page.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R

val fontPoppinsReguler = FontFamily(
    Font(
        googleFont = fontPoppins,
        fontProvider = provider,
        weight = FontWeight.Normal
    )
)

@Composable
fun QuotesBox(
    modifier: Modifier = Modifier,
    quote: String,
) {
    Box(
        modifier = modifier
            .drawBehind {
                drawRoundRect(
                    Color(0xFFE6E6E6),
                    cornerRadius = CornerRadius(20.dp.toPx()),
                )
            }
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(
                R.drawable.icon_quote
            ),
            contentDescription = null,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.CenterEnd)
        )
        Text(
            text = "\"$quote\"",
            style = TextStyle(
                fontSize = 14.sp,
                fontFamily = fontPoppinsReguler,
                color = Color(0xFF707070),
            ),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(start = 8.dp, top = 16.dp, bottom = 16.dp, end = 16.dp)
        )
    }

}