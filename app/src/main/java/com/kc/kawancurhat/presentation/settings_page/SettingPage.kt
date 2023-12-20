package com.kc.kawancurhat.presentation.settings_page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.kc.kawancurhat.R
import com.kc.kawancurhat.presentation.settings_page.components.AboutButton
import com.kc.kawancurhat.presentation.settings_page.components.LanguageButton
import com.kc.kawancurhat.presentation.settings_page.components.ThemeButton
import com.kc.kawancurhat.presentation.welcome_page.GoogleAuthUiClient
import com.kc.kawancurhat.presentation.welcome_page.UserData
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingPage(
    userData: UserData?, onBackPressed: () -> Unit, googleAuthUiClient: GoogleAuthUiClient
) {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val context = LocalContext.current
    NavHost(navController = navController, startDestination = "settings") {
        composable("settings") {
            Scaffold(topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Settings")
                    },
                    navigationIcon = {
                        IconButton(onClick = { onBackPressed() }) {
                            Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back Icon")
                        }
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
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (userData?.profilePictureUrl != null) {
                        AsyncImage(
                            model = userData.profilePictureUrl,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .size(120.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (userData?.username != null) {
                        Text(
                            text = userData.username,
                            textAlign = TextAlign.Center,
                            fontSize = 22.sp
                        )
                    }
                    if (userData?.email != null) {
                        Text(
                            text = userData.email,
                            textAlign = TextAlign.Center,
                            fontSize = 18.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    LanguageButton(onClick = {
                        navController.navigate("lang_set")
                    })
                    ThemeButton(onClick = {
                        navController.navigate("theme_set")
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                    AboutButton(onContactClick = {
                        navController.navigate("contact_page")
                    }, onPrivPolicyClick = {
                        navController.navigate("privacy_policy")
                    })
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            scope.launch {
                                googleAuthUiClient.signOut()
                                Toast.makeText(
                                    context, "Signed Out", Toast.LENGTH_LONG
                                ).show()
                                onBackPressed()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red
                        ),
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(62.dp)
                            .padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.log_out), color = Color.White
                        )
                    }
                }
            })
        }

        composable("lang_set") {
            LanguageSettings(onBackPressed = {
                navController.navigateUp()
            })
        }

        composable("theme_set") {
            ThemeSettings(onBackPressed = {
                navController.navigateUp()
            })
        }

        composable("contact_page") {
            ContactPage(onBackPressed = {
                navController.navigateUp()
            })
        }

        composable("privacy_policy") {
            PrivacyPolicy(onBackPressed = {
                navController.navigateUp()
            })
        }

    }
}