package com.kc.kawancurhat.presentation.settings_page.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R

@Composable
fun ThemeButton(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.Start,
    ) {
        OutlinedButton(
            onClick = onClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .height(62.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_theme),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(20.dp)
            )
            Text(
                text = stringResource(R.string.theme_settings),
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(3f)
            )
            Text(
                text = "Dark Mode",
                fontSize = 14.sp,
                color = Color.Blue,
            )
        }
    }
}