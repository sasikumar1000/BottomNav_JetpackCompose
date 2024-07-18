package com.learning.mybottomnav

import androidx.collection.mutableIntListOf
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(modifier: Modifier = Modifier) {

    val navItems = listOf(
        NavItems("Home",Icons.Default.Home),
        NavItems("Notification",Icons.Default.Notifications,5),
        NavItems("Settings",Icons.Default.Settings),
        NavItems("Animation",Icons.Default.Build)
    )

    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NavigationBar {

                navItems.forEachIndexed { index, navItems ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick = {

                            selectedIndex = index
                        },
                        icon = {
                            BadgedBox(badge = {
                                if(navItems.badge > 0)
                                Badge() {
                                    Text(text = navItems.badge.toString())
                                }
                            }) {
                                Icon(imageVector = navItems.icon, contentDescription = "Icons")

                            }
                        },
                        label = {
                            Text(text = navItems.lables)
                        })
                }
            }
        }
    ) { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding),selectedIndex)
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedInddex: Int) {

    when(selectedInddex) {
        0 -> HomeScreen()
        1 -> NotificationScreen()
        2 -> SettingsScreen()
        3 -> AnimationScreen()
    }

}
