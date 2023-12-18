package com.kc.kawancurhat.presentation.home_page.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChatBubbleOutline
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Map
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kc.kawancurhat.model.BottomBarItem
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun BottomBar(
    modifier: Modifier = Modifier
) {
    val activeNavigationFlow = MutableStateFlow("Home")
    NavigationBar(
        modifier = modifier
    ) {
        val navigationItems = listOf(
            BottomBarItem(
                title = "Home",
                icon = Icons.Filled.Home
            ),
            BottomBarItem(
                title = "Chatbot",
                icon = Icons.Filled.ChatBubbleOutline
            ),
            BottomBarItem(
                title = "Psychologist",
                icon = Icons.Filled.Map
            ),
            BottomBarItem(
                title = "Settings",
                icon = Icons.Filled.Settings
            )
        )
        navigationItems.map {
            NavigationBarItem(
                selected = activeNavigationFlow.value == it.title,
                onClick = {
                      activeNavigationFlow.value = it.title
                },
                icon = {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.title
                    )
                },
                label = {
                    Text(it.title)
                }
            )
        }
    }
}