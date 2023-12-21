package com.kc.kawancurhat.ui.navigation

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.core.content.ContextCompat
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController, currentPage: Int, context: Context) {
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(currentPage)
    }
    val items = NavigationItems.items
    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) {
        isGranted: Boolean ->
        if (!isGranted) {
            Log.e("Permission", "PERMISSION DENIED")
            Toast.makeText(context, "PERMISSION DENIED", Toast.LENGTH_SHORT).show()
        }
    }
    NavigationBar {
        items.forEachIndexed{ index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    if (item.title == "Map") {
                        when (PackageManager.PERMISSION_DENIED) {
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.ACCESS_FINE_LOCATION
                            ) -> {
                                launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
                            }
                            ContextCompat.checkSelfPermission(
                                context,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            ) -> {
                                launcher.launch(Manifest.permission.ACCESS_COARSE_LOCATION)
                            }
                        }
                    }
                    navController.navigate(item.title)
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = false,
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}