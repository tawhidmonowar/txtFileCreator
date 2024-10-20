package com.tawhid.txtfilecreator.presentation.util

sealed class Screens (val screen: String) {
    data object TextEditor: Screens("textEditor")
    data object TextFiles: Screens("textFiles")
    data object TextPins: Screens("textPins")

}