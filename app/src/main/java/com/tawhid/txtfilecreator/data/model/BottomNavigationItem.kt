package com.tawhid.txtfilecreator.data.model

import androidx.compose.ui.graphics.painter.Painter
data class BottomNavigationItem(
    val title: String,
    val selectedIcon: Painter,
    val unselectedIcon: Painter,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)