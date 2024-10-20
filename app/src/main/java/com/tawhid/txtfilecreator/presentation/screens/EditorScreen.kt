package com.tawhid.txtfilecreator.presentation.screens

import android.view.View
import android.widget.EditText
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import com.tawhid.txtfilecreator.R

@Composable
fun TextEditor()
{
    AndroidView (
        factory = {
            View.inflate(it, R.layout.text_editor_layout, null)
        },
        modifier = Modifier.fillMaxSize(),
        update = {
            val edit_text = it.findViewById<EditText>(R.id.editText)
            edit_text.setText("Hello World")
        }
    )
}