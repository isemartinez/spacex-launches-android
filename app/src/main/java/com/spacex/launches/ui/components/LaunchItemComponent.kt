package com.spacex.launches.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.spacex.launches.data.models.presentation.PresentationItem

@Composable
fun LaunchItemComponent(modifier: Modifier = Modifier, launch: PresentationItem.Launch , onClick: () -> Unit) {

    val item = launch.launch

    Card(
        modifier = modifier
            .clickable {
                onClick()
            }
            .fillMaxWidth()
            .padding(top = 3.dp, bottom = 3.dp),
        shape = RectangleShape,
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {

                AsyncImage(
                    modifier = Modifier.fillMaxSize(),
                    model = item.launchPadImageURL,
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.2f))
                )

                Text(
                    text = item.flightNumber,
                    color = Color.Black,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .background(Color.White, shape = RoundedCornerShape(2.dp))
                        .border(1.dp, Color.Black, shape = RoundedCornerShape(2.dp))
                        .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                        .align(Alignment.TopEnd)
                )

            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(modifier = Modifier.weight(0.7f)) {
                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = item.launchDate,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                    )

                    Text(
                        modifier = Modifier
                            .padding(6.dp),
                        text = item.launchSiteName,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal
                        )

                    )

                    Text(
                        modifier = Modifier
                            .padding(8.dp),
                        text = item.missionName,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                    )
                }

                Column(
                    modifier = Modifier.weight(0.3f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = item.rocketType,
                        color = Color.Black,
                        style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                        modifier = Modifier
                            .background(Color.White, shape = RoundedCornerShape(6.dp))
                            .border(1.dp, Color.Black, shape = RoundedCornerShape(6.dp))
                            .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 2.dp)
                    )

                    Text(
                        modifier = Modifier
                            .padding(top = 10.dp),
                        text = item.rocketName,
                        style = TextStyle(
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        textAlign = TextAlign.Center
                    )

                }

            }

            BlackButtonComponent(text = "LEARN MORE", onClick = onClick)

        }
    }
}
