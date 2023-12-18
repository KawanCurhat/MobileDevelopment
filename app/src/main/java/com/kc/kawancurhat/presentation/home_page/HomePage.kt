package com.kc.kawancurhat.presentation.home_page

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.kc.kawancurhat.R
import com.kc.kawancurhat.model.dummyMenu
import com.kc.kawancurhat.model.dummyMood
import com.kc.kawancurhat.presentation.home_page.components.MenuItem
import com.kc.kawancurhat.presentation.home_page.components.MoodItem
import com.kc.kawancurhat.presentation.home_page.components.MsgBox
import com.kc.kawancurhat.presentation.home_page.components.QuotesBox
import com.kc.kawancurhat.presentation.settings_page.SettingPage
import com.kc.kawancurhat.presentation.welcome_page.UserData

val provider = GoogleFont.Provider(
    providerAuthority = "com.google.android.gms.fonts",
    providerPackage = "com.google.android.gms",
    certificates = R.array.com_google_android_gms_fonts_certs
)

val fontInter = GoogleFont("Inter")
val fontInterFamily = FontFamily(
    Font(
        googleFont = fontInter,
        fontProvider = provider,
        weight = FontWeight.Normal
    )
)

@Composable
fun HomePage(
    userData: UserData?,
    onOpenMap: () -> Unit
) {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                if (userData?.profilePictureUrl != null) {
                    IconButton(
                        onClick = {
                            navController.navigate("settings")
                        },
                        modifier = Modifier.align(Alignment.End)
                    ) {
                        AsyncImage(
                            model = userData.profilePictureUrl,
                            contentDescription = "Profile Picture",
                            modifier = Modifier
                                .align(Alignment.End)
                                .size(48.dp)
                                .clip(CircleShape),
                            contentScale = ContentScale.Crop,
                        )
                    }
                    if (userData.username != null) {
                        Text(
                            buildAnnotatedString {
                                withStyle(style = SpanStyle(fontFamily = fontInterFamily)) {
                                    append(stringResource(R.string.hello_welcome_page))
                                }
                                withStyle(
                                    style = SpanStyle(
                                        fontWeight = FontWeight.Bold,
                                        fontFamily = fontInterFamily
                                    )
                                ) {
                                    append(userData.username.substring(0, userData.username.indexOf(" ")))
                                }
                                append("!")
                                withStyle(
                                    style = SpanStyle(
                                        fontSize = 18.sp,
                                        fontFamily = fontInterFamily
                                    )
                                ) {
                                    append(stringResource(R.string.how_are_you_feeling_today))
                                }
                            },
                            style = TextStyle(
                                fontSize = 24.sp,
                                textAlign = TextAlign.Start
                            ),
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            contentPadding = PaddingValues(horizontal = 16.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(dummyMood, key = { it.textMood }) { mood ->
                                MoodItem(mood)
                            }
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        MsgBox(
                            onChatClick = {
                                Toast.makeText(
                                    context,
                                    "Not yet",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },
                            modifier = Modifier.fillMaxWidth()
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyRow(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            contentPadding = PaddingValues(horizontal = 8.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(dummyMenu, key = { it.textMenu }) { menu ->
                                MenuItem(menu)
                            }
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        QuotesBox()

                    }
                }
            }
        }

        composable("settings") {
            SettingPage(
                userData = userData,
                onBackPressed = {
                    navController.navigateUp()
                }
            )
        }
    }
}
