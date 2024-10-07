package com.spacex.launches.ui.main.launches

import android.graphics.Color.BLACK
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.pulltorefresh.PullToRefreshBox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.spacex.flights.R
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result.Error
import com.spacex.launches.data.states.Result.Success
import com.spacex.launches.navigation.NavRoutes
import com.spacex.launches.ui.components.LaunchItemComponent
import com.spacex.launches.ui.components.LaunchesHeaderComponent
import com.spacex.launches.ui.main.launches.viewmodel.LaunchesViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LaunchesScreen(
    navHostController: NavHostController,
    viewModel: LaunchesViewModel = hiltViewModel()
) {

    val coroutineScope = rememberCoroutineScope()
    val view = LocalView.current
    val window = (LocalView.current.context as? androidx.activity.ComponentActivity)?.window
    var isRefreshing by remember { mutableStateOf(false) }

    window?.let {
        it.statusBarColor = BLACK
        val windowInsetsController = WindowCompat.getInsetsController(it, view)
        windowInsetsController.isAppearanceLightStatusBars = false
    }

    var launches by remember { mutableStateOf(emptyList<PresentationItem>()) }
    LaunchedEffect(Unit) {
        isRefreshing = true
        viewModel.fetchLastTwentyLaunches().let {
            when (it) {
                is Success -> {
                    launches = it.data
                }

                is Error -> {
                    val message = it.exception.message
                    Toast.makeText(view.context, message, Toast.LENGTH_LONG).show()
                }
            }
            isRefreshing = false
        }
    }

    val onRefresh: () -> Unit = {
        isRefreshing = true
        coroutineScope.launch {
            when (val result = viewModel.fetchLastTwentyLaunches(refresh = true)) {
                is Success -> {
                    launches = result.data
                }

                is Error -> {
                    val message = result.exception.message
                    Toast.makeText(view.context, message, Toast.LENGTH_LONG).show()
                }
            }
            isRefreshing = false
        }
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.height(80.dp),
                title = {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            modifier = Modifier
                                .fillMaxWidth(0.5f)
                                .padding(top = 30.dp)
                                .align(Alignment.Center),
                            painter = painterResource(id = R.drawable.ic_space_x),
                            contentDescription = "SpaceX Logo"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Black
                )
            )
        },
        content = { paddingValues ->
            PullToRefreshBox(
                modifier = Modifier.padding(paddingValues),
                isRefreshing = isRefreshing, onRefresh = onRefresh
            ) {

                Box(
                    modifier = Modifier.fillMaxSize()
                ) {

                    LazyColumn(modifier = Modifier.fillMaxWidth()) {
                        items(launches) {
                            when (it) {
                                is PresentationItem.Header -> {
                                    LaunchesHeaderComponent(
                                        title = it.title,
                                        backgroundURL = it.backgroundURL
                                    )
                                }

                                is PresentationItem.Launch -> {
                                    LaunchItemComponent(launch = it) {
                                        navHostController.navigate(
                                            NavRoutes.LAUNCH_DETAIL.replace(
                                                "{launchId}",
                                                it.launch.id.toString()
                                            )
                                        )
                                    }
                                }
                            }

                        }
                    }
                }

            }
        },
        containerColor = Color.Black
    )
}
