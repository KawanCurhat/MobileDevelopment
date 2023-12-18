package com.kc.kawancurhat.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.kc.kawancurhat.R

data class Menu (
    @DrawableRes val imageMenu: Int,
    @StringRes val textMenu: Int
)

val dummyMenu = listOf(
    R.drawable.icon_journal to R.string.journal_txt,
    R.drawable.icon_article to R.string.article_txt
).map { Menu(it.first, it.second) }