package com.learning.mybottomnav

import androidx.compose.ui.graphics.vector.ImageVector

data class NavItems(
    val lables : String,
    val icon: ImageVector,
    val badge : Int = 0
)
