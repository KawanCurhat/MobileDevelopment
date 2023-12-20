package com.kc.kawancurhat.presentation.settings_page

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kc.kawancurhat.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSettings(
    onBackPressed: () -> Unit
) {
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(text = stringResource(R.string.language_settings))
            },
            navigationIcon = {
                IconButton(onClick = { onBackPressed() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back Icon")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary, titleContentColor = Color.White
            ),
        )
    }, content = {
        val langOptions = listOf("English", "Indonesia")
        val (selectedOption, onOptionSelected) = remember { mutableStateOf(langOptions[0]) }
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            langOptions.forEach { text ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(selected = (text == selectedOption), onClick = {
                            Toast
                                .makeText(
                                    context, "Not yet", Toast.LENGTH_SHORT
                                )
                                .show()
                        })
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(selected = (text == selectedOption),
                        onClick = { onOptionSelected(text) })
                    Text(
                        text = text, modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
        }
    })
}