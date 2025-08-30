package com.joshgm3z.poster

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ModeComment
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
fun HomeScreen(
    onNewPostClick: () -> Unit = {},
) {
    Scaffold(
        topBar = { TopHeading() },
        floatingActionButton = {
            NewPostButton(onNewPostClick)
        }
    ) { ip ->
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

@Preview
@Composable
private fun PreviewHomeScreen() {
    PosterTheme {
        HomeScreen()
    }
}