package com.kc.kawancurhat.presentation.home_page.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kc.kawancurhat.R
import com.kc.kawancurhat.model.Mood
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

@Composable
fun MoodItem(
    mood: Mood,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        IconButton(onClick = {
            Toast.makeText(
                context,
                "Not yet",
                Toast.LENGTH_SHORT
            ).show()
        }) {
            Image(
                painter = painterResource(mood.imageMood),
                contentDescription = null,
                modifier = Modifier
                    .requiredSize(40.dp)
                    .clip(CircleShape)
            )
        }
        Text(
            text = stringResource(mood.textMood),
            fontSize = 12.sp,
            modifier = Modifier.paddingFromBaseline(top = 16.dp, bottom = 8.dp)
        )
    }
}

@Composable
@Preview(showBackground = false)
fun MoodItemPreview() {
    KawanCurhatTheme {
        MoodItem(
            mood = Mood(
                R.drawable.angry,
                R.string.mood_happy
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}