package com.tawhid.txtfilecreator

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.contentColorFor
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Editor() {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp)
    ) {
        CustomTextField(
            value = text,
            onValueChanged = { text = it },
            hintText = "Text Editor",
            textStyle = TextStyle(
                color = Color.Green
            )
        )
    }
}

@Composable
fun CustomTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    hintText: String = "",
    textStyle: TextStyle = MaterialTheme.typography.body1,
    maxLine: Int = 100
) {
    val scrollState = rememberScrollState() // Scroll state to track scroll position
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(androidx.compose.material3.MaterialTheme.colorScheme.surface)
            .padding(10.dp)
    )
    {
        BasicTextField(
            value = value,
            textStyle = textStyle,
            cursorBrush = SolidColor(Color.Red),
            maxLines = maxLine,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(1f)
                .verticalScroll(scrollState)
                .background(androidx.compose.material3.MaterialTheme.colorScheme.surface)

                .padding(10.dp),
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
}

@Preview(showBackground = true)
@Composable
fun EditorPreview() {
    Editor()
}