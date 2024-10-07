package com.spacex.launches.ui.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Composable
fun BlackButtonComponent( text: String, onClick: () -> Unit){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 8.dp, end = 8.dp, bottom = 20.dp, top = 20.dp)
            .border(2.dp, Color.White, RectangleShape),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Black
        ),
        shape = RectangleShape
    ) {
        Text(
            text = text,
            color = Color.White
        )
    }
}