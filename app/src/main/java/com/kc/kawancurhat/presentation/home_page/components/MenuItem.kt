package com.kc.kawancurhat.presentation.home_page.components

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R
import com.kc.kawancurhat.model.Menu
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

val fontPoppins = GoogleFont("Poppins")
val fontPoppinsBold = FontFamily(
    Font(
        googleFont = fontPoppins,
        fontProvider = provider,
        weight = FontWeight.Bold
    )
)

@Composable
fun MenuItem(
    menu: Menu,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = {
                Toast.makeText(
                    context,
                    "Not yet",
                    Toast.LENGTH_SHORT
                ).show()
            },
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE6E6E6)
            ),
            modifier = Modifier
                .height(62.dp)
                .width(145.dp),
        ) {
            Icon(
                painter = painterResource(menu.imageMenu),
                contentDescription = null,
                tint = Color.Unspecified,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp),
            )
            Text(
                text = stringResource(menu.textMenu),
                fontFamily = fontPoppinsBold,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp),
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun MenuItemPreview() {
    KawanCurhatTheme {
        MenuItem(
            menu = Menu(
                R.drawable.icon_journal,
                R.string.journal_txt
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}