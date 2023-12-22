@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.kc.kawancurhat.presentation.chatbot

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.kc.kawancurhat.R
import com.kc.kawancurhat.ui.navigation.BottomBar
import com.kc.kawancurhat.ui.theme.KawanCurhatTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatBotPage(
    navController: NavController
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.chat_topbar))
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = Color.White
                ),
            )
        }, content = {
            Column(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
            ) {
                ChatScreen(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally)
                )
                ChatInput(

                )
            }
        }, bottomBar = {
            BottomBar(navController = navController, currentPage = 1, context)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun ChatBotPagePrev() {
    KawanCurhatTheme {
        ChatBotPage(navController = rememberNavController())
    }
}