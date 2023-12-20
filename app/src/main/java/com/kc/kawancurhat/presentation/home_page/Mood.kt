package com.kc.kawancurhat.presentation.home_page

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kc.kawancurhat.R

data class Mood (
    @DrawableRes val imageMood: Int,
    @StringRes val textMood: Int
)

val dummyMood = listOf(
    R.drawable.happy to R.string.mood_happy,
    R.drawable.calm to R.string.calm_mood,
    R.drawable.angry to R.string.angry_mood,
    R.drawable.sad to R.string.sad_mood
).map { Mood(it.first, it.second) }