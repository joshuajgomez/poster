package com.joshgm3z.poster

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewPostButton(onClick: () -> Unit = {}) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier.background(
            colorScheme.primary,
            shape = RoundedCornerShape(20.dp)
        )
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = null,
            tint = colorScheme.primaryContainer
        )
        Text(
            "New post",
            color = colorScheme.primaryContainer
        )
    }
}