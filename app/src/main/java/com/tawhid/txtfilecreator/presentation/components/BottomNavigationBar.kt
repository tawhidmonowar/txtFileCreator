package com.tawhid.txtfilecreator.presentation.components

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.tawhid.txtfilecreator.R
import com.tawhid.txtfilecreator.data.model.BottomNavigationItem
import com.tawhid.txtfilecreator.presentation.util.Screens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        BottomNavigationItem(
            title = ".txtEditor",
            selectedIcon = painterResource(id = R.drawable.edit_txt),
            unselectedIcon = painterResource(id = R.drawable.edit_txt),
            hasNews = false,
        ),
        BottomNavigationItem(
            title = ".txtFiles",
            selectedIcon = painterResource(id = R.drawable.text_file_filled),
            unselectedIcon = painterResource(id = R.drawable.text_file_outline),
            hasNews = false,
            badgeCount = 99
        ),
        BottomNavigationItem(
            title = ".txtPins",
            selectedIcon = painterResource(id = R.drawable.pin_filled),
            unselectedIcon = painterResource(id = R.drawable.pin_outline),
            hasNews = true,
        ),
    )

    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    when (index) {
                        0 -> navController.navigate(Screens.TextEditor.screen) { popUpTo(0) }
                        1 -> navController.navigate(Screens.TextFiles.screen) { popUpTo(0) }
                        2 -> navController.navigate(Screens.TextPins.screen) { popUpTo(0) }
                    }
                },
                label = {
                    Text(text = item.title)
                },
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString() + "+")
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }
            )
        }
    }
}