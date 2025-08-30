package com.joshgm3z.poster

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material.icons.filled.ModeComment
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joshgm3z.poster.ui.theme.PosterTheme

@Composable
fun HomeScreen() {
    Scaffold(topBar = { TopHeading() }) { ip ->
        Surface(modifier = Modifier.padding(ip)) {
            PostsList()
        }
    }
}

@Composable
fun TopHeading() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .padding(
                horizontal = 10.dp,
                vertical = 10.dp
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(
            "Poster",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun PostsList() {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(15.dp),
    ) {
        items(10) {
            PostItem(it)
            Spacer(Modifier.size(10.dp))
            HorizontalDivider()
        }
    }
}

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
fun PostFooter() {
    Row {
        Icon(
            Icons.Outlined.ModeComment,
            contentDescription = null
        )
        Spacer(Modifier.size(5.dp))
        Text("234")
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
private fun PreviewHomeScreen() {
    PosterTheme {
        HomeScreen()
    }
}