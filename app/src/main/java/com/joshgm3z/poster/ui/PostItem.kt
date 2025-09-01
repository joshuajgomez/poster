package com.joshgm3z.poster.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.poster.ui.theme.PosterTheme

@Composable
fun PostItem(it: Int) {
    Row(
        modifier = Modifier.padding(horizontal = 10.dp),
    ) {
        VoteBox()
        Spacer(Modifier.size(10.dp))
        Column {
            PostHeading()
            Spacer(Modifier.size(5.dp))
            Box(
                modifier = Modifier
                    .background(
                        color = colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .padding(10.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    "This is a long post #$it with so many sentences enough for multiple lines i think",
                    color = colorScheme.secondary
                )
            }
            Spacer(Modifier.size(8.dp))
            PostFooter()
        }
    }
}

@Composable
fun PostHeading() {
    Row {
        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
        Spacer(Modifier.size(10.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Text(
                    "textyguy",
                    fontSize = 20.sp,
                    color = colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    "yesterday",
                    color = colorScheme.tertiary,
                    fontSize = 15.sp
                )
            }
            Icon(
                Icons.Default.MoreVert,
                contentDescription = null
            )
        }
    }
}

@Composable
fun VoteBox() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        Icon(
            Icons.Default.ArrowUpward,
            contentDescription = null,
            tint = colorScheme.primary,
        )
        Text(
            "23",
            fontWeight = FontWeight.Bold
        )
        Icon(
            Icons.Default.ArrowDownward,
            contentDescription = null,
            tint = colorScheme.primary,
        )
    }
}

@Preview
@Composable
fun PreviewPostItem() {
    PosterTheme {
        PostItem(1)
    }
}