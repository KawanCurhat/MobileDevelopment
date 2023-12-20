package com.kc.kawancurhat.presentation.home_page.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.kc.kawancurhat.R

val fontPoppins = GoogleFont("Poppins")
val fontPoppinsBold = FontFamily(
    Font(
        googleFont = fontPoppins, fontProvider = provider, weight = FontWeight.Bold
    )
)

@Composable
fun MenuItem(
    modifier: Modifier = Modifier, navController: NavController
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.navigate("Journal")
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6E6E6)
                ),
                modifier = Modifier
                    .height(62.dp)
                    .width(152.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_journal),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(20.dp),
                )
                Text(
                    text = stringResource(R.string.journal_txt),
                    fontFamily = fontPoppinsBold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp),
                    color = Color.Black
                )
            }
        }
        Row(
            modifier = modifier, verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                    navController.navigate("Article")
                },
                shape = RoundedCornerShape(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFE6E6E6)
                ),
                modifier = Modifier
                    .height(62.dp)
                    .width(152.dp),
            ) {
                Icon(
                    painter = painterResource(R.drawable.icon_article),
                    contentDescription = null,
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .size(20.dp),
                )
                Text(
                    text = stringResource(R.string.journal_txt),
                    fontFamily = fontPoppinsBold,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp),
                    color = Color.Black
                )
            }
        }
    }
}