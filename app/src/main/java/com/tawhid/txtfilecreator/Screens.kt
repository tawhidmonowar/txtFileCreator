package com.tawhid.txtfilecreator

sealed class Screens (val screen: String) {
    data object Editor: Screens ("editor")
    data object Files: Screens ("files")
    data object Pins: Screens ("pins")

}