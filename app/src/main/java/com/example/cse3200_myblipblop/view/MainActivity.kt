package com.example.cse3200_myblipblop.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.cse3200_myblipblop.ui.theme.CSE3200_MyBlipBlopTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSE3200_MyBlipBlopTheme {
                VideoFeedScreen()
            }
        }
    }
}

