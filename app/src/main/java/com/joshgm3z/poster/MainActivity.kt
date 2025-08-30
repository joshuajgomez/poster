package com.joshgm3z.poster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.joshgm3z.poster.ui.theme.PosterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PosterTheme {
                var showNewPostScreen by remember { mutableStateOf(false) }
                when {
                    showNewPostScreen -> NewPostScreen {
                        showNewPostScreen = false
                    }

                    else -> HomeScreen {
                        showNewPostScreen = true
                    }
                }
            }
        }
    }
}
