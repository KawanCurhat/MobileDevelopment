package com.kc.kawancurhat.presentation.home_page.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R
import com.kc.kawancurhat.ui.theme.Blue
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontInter = GoogleFont("Inter")
val fontInterFamily = FontFamily(
    Font(
        googleFont = fontInter,
        fontProvider = provider,
        weight = FontWeight.Normal
    )
)
val fontInterExtraBold = FontFamily(
    Font(
        googleFont = fontInter,
        fontProvider = provider,
        weight = FontWeight.ExtraBold
    )
)

@Composable
fun MsgBox(
    modifier: Modifier = Modifier,
    onChatClick: () -> Unit,
) {
    Box(
        modifier = modifier
            .drawBehind {
                drawRoundRect(
                    Color(0xFF4B9EEB),
                    style = Stroke(width = 4f),
                    cornerRadius = CornerRadius(20.dp.toPx())
                )
                drawRoundRect(
                    Color(0xFFD6EBFF),
                    cornerRadius = CornerRadius(20.dp.toPx()),
                )
            }
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.medication_icon),
            contentDescription = stringResource(
                R.string.medication_icon
            ),
            modifier = Modifier
                .size(64.dp)
                .align(Alignment.BottomEnd),
        )
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                "Try AI Consultation",
                fontFamily = fontInterExtraBold,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontFamily = fontInterFamily)) {
                        append("Let’s open up to the things that")
                    }
                    withStyle(style = SpanStyle(fontFamily = fontInterFamily)) {
                        append("\nmatter the most. Integrated with AI")
                    }
                },
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color(0xFF2B2B2B),
                    textAlign = TextAlign.Start
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedButton(onClick = onChatClick, border = BorderStroke(1.dp, Blue)) {
                Text("Chat Now")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MsgBoxTest() {
    KawanCurhatTheme {
        MsgBox {

        }
    }
}