package com.spacex.launches.ui.main.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.spacex.launches.data.models.presentation.Launch
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.ui.main.launches.viewmodel.LaunchesViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchDetailScreen(
    navHostController: NavHostController,
    launchId: Long?,
    viewModel: LaunchesViewModel = hiltViewModel()
) {

    var launch by remember { mutableStateOf<Launch?>(null) }

    LaunchedEffect(Unit) {
        launch = viewModel.fetchLaunchById(launchId)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.height(80.dp),
                title = {
                    Text(
                        text = "Launch ",
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically)
                    )
                },
                navigationIcon = {
                    IconButton(
                        modifier = Modifier
                            .fillMaxHeight()
                            .wrapContentHeight(Alignment.CenterVertically),
                        onClick = {
                            navHostController.popBackStack()
                        }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },
        content = { paddingValues ->
            Column(modifier = Modifier.padding(paddingValues)) {
                AsyncImage(
                    modifier = Modifier.fillMaxWidth()
                        .height(250.dp),
                    model = launch?.launchPadImageURL, contentDescription = "Launch Pad Image",
                    contentScale = ContentScale.Crop
                )

                Text(
                    modifier = Modifier
                        .padding(top = 14.dp, start = 8.dp, end = 8.dp),
                    text = launch?.launchDate?: "",
                    style = TextStyle(color = Color(0xFF8B939B), fontSize = 16.sp)
                )

                Text(
                    modifier = Modifier
                        .padding(top = 14.dp, start = 8.dp, end = 8.dp),
                    text = launch?.launchSiteName?: "",
                    style = TextStyle(color = Color(0xFF8B939B), fontSize = 16.sp)
                )

                Text(
                    modifier = Modifier
                        .padding(top = 20.dp, start = 8.dp, end = 8.dp),
                    text = launch?.missionName?: "",
                    style = TextStyle(color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                )

                Text(
                    modifier = Modifier
                        .padding(top = 40.dp, start = 8.dp, end = 8.dp),
                    text = launch?.flightDetails?: "No details available for this mission",
                    style = TextStyle(color = Color.White, fontSize = 16.sp)
                )
            }
        },
        containerColor = Color.Black
    )
}