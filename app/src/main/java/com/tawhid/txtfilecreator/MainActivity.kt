package com.tawhid.txtfilecreator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tawhid.txtfilecreator.presentation.components.BottomNavigationBar
import com.tawhid.txtfilecreator.presentation.components.TopBar
import com.tawhid.txtfilecreator.presentation.screens.TextEditor
import com.tawhid.txtfilecreator.presentation.screens.TextFiles
import com.tawhid.txtfilecreator.presentation.screens.TextPins
import com.tawhid.txtfilecreator.presentation.util.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.TextFiles.screen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.TextEditor.screen) { TextEditor() }
            composable(Screens.TextFiles.screen) { TextFiles() }
            composable(Screens.TextPins.screen) { TextPins() }
        }
    }
}