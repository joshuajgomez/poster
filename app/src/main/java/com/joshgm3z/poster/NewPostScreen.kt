package com.joshgm3z.poster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.poster.ui.theme.PosterTheme

@Composable
fun NewPostScreen(
    closeScreen: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Column(modifier = Modifier.weight(1f)) {
            NewPostHeading(closeScreen)
            NewPostContent()
        }
        Spacer(Modifier.size(10.dp))
        NewPostFooter()
    }
}

@Composable
fun NewPostFooter() {
    Row(
        horizontalArrangement = Arrangement.End,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = {},
        ) {
            Text("Post")
        }
    }
}

@Composable
fun NewPostContent() {
    Box(
        modifier = Modifier
            .background(
                color = colorScheme.secondaryContainer,
                shape = RoundedCornerShape(10.dp)
            )
            .padding(10.dp)
            .fillMaxSize()
    ) {
        var text by remember { mutableStateOf("") }
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun NewPostHeading(onCloseClick: () -> Unit = {}) {
    Row(
        modifier = Modifier
            .height(80.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onCloseClick) {
            Icon(
                Icons.Default.Close,
                contentDescription = null
            )
        }
        Spacer(Modifier.size(10.dp))
        Text(
            "New post",
            fontSize = 25.sp
        )
    }
}

@Preview
@Composable
private fun PreviewNewPostScreen() {
    PosterTheme {
        NewPostScreen()
    }
}