package com.kc.kawancurhat.presentation.settings_page.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R

@Composable
fun AboutButton(
    onContactClick: () -> Unit,
    onPrivPolicyClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.Start,
    ) {
        OutlinedButton(
            onClick = onContactClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .height(62.dp)
                .fillMaxWidth()
        ) {
            Icon(
                Icons.Filled.Email,
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(20.dp)
            )
            Text(
                text = stringResource(R.string.contact_us_btn),
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(3f)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedButton(
            onClick = onPrivPolicyClick,
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFFFFF)
            ),
            modifier = Modifier
                .height(62.dp)
                .fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(R.drawable.icon_privacy),
                contentDescription = null,
                tint = Color.Black,
                modifier = Modifier
                    .padding(end = 16.dp)
                    .size(20.dp)
            )
            Text(
                stringResource(R.string.privacy_policy_btn),
                fontSize = 14.sp,
                color = Color.Black,
                modifier = Modifier.weight(3f)
            )
        }
    }
}