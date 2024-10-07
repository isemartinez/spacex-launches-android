package com.spacex.launches.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun LaunchesHeaderComponent(
    modifier: Modifier = Modifier,
    title: String,
    backgroundURL: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
    ) {

        AsyncImage(
            modifier = Modifier
                .fillMaxSize(),
            model = backgroundURL,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black.copy(alpha = 0.5f))
        )

        Text(
            modifier = Modifier
                .align(Alignment.Center),
            text = title,
            style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold, fontSize = 26.sp),
        )

    }
}