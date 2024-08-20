package ru.relabs.storekeeper.screen.Component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun TimeComponent(time: String, color: Color) {
    Text(text = "Time: $time", color = color)
}
