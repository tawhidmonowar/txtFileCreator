package com.tawhid.txtfilecreator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Editor() {
    var text by remember {
        mutableStateOf("")
    }
    Box(modifier = Modifier.fillMaxSize()) {
        CustomTextField(
            value = text,
            onValueChanged = {text = it},
            hintText = "Text Editor"
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    hintText: String = "",
    textStyle: TextStyle = MaterialTheme.typography.body1,
    maxLine: Int = 10
) {
    BasicTextField(
        value = value,
        textStyle = textStyle,
        maxLines = maxLine,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(.5f)
            .background(Color.Gray),
        onValueChange = onValueChanged,
        decorationBox = { innerTextField ->
            Box(modifier = Modifier) {
                if (value.isEmpty()) {
                    Text(text = hintText)
                }
                innerTextField()
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EditorPreview() {
    Editor()
}