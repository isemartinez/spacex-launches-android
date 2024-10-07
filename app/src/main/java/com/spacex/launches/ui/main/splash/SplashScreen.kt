package com.spacex.launches.ui.main.splash

import android.graphics.Color.BLACK
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.spacex.flights.R
import com.spacex.launches.data.models.presentation.PresentationItem
import com.spacex.launches.data.states.Result
import com.spacex.launches.navigation.NavRoutes
import com.spacex.launches.ui.components.BlackButtonComponent
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(
    navHostController: NavHostController,
    splashScreenViewModel: SplashScreenViewModel = hiltViewModel()
) {
    val view = LocalView.current
    val window = (LocalView.current.context as? androidx.activity.ComponentActivity)?.window
    val coroutineScope = rememberCoroutineScope()

    window?.let {
        it.statusBarColor = BLACK
        val windowInsetsController = WindowCompat.getInsetsController(it, view)
        windowInsetsController.isAppearanceLightStatusBars = false
    }

    var playParticlesAnimation by remember { mutableStateOf(false) }

    var error by remember { mutableStateOf<String?>(null) }

    val preloaderLottieComposition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(
            R.raw.particles_animation
        )
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = LottieConstants.IterateForever,
        isPlaying = playParticlesAnimation
    )

    val fetchLaunches: suspend () -> Unit = {
        error = null
        playParticlesAnimation = true
        when (val result = splashScreenViewModel.fetchLastTwentyLaunches()) {
            is Result.Success<List<PresentationItem>> -> {
                playParticlesAnimation = false
                navHostController.navigate(NavRoutes.LAUNCHES_SCREEN)
            }

            is Result.Error -> {
                playParticlesAnimation = false
                error = result.exception.message
            }
        }
    }

    LaunchedEffect(Unit) {
        fetchLaunches()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Image(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(0.5f),
            painter = painterResource(id = R.drawable.ic_space_x),
            contentDescription = "SpaceX Logo"
        )

        LottieAnimation(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            composition = preloaderLottieComposition,
            progress = preloaderProgress
        )

        error?.let {

            Column(modifier = Modifier.align(Alignment.BottomCenter)) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = it, color = Color.White
                )
                BlackButtonComponent(text = "TRY AGAIN") {
                    coroutineScope.launch {
                        fetchLaunches()
                    }
                }
            }
        }
    }
}