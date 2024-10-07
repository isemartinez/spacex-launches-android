package com.spacex.launches.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.spacex.launches.ui.main.detail.LaunchDetailScreen
import com.spacex.launches.ui.main.launches.LaunchesScreen
import com.spacex.launches.ui.main.splash.SplashScreen

@Composable
fun NavGraph(navHostController: NavHostController) {

    val startDestination = NavRoutes.SPLASH_SCREEN

    NavHost(navController = navHostController, startDestination = startDestination) {
        composable(route = NavRoutes.SPLASH_SCREEN) {
            SplashScreen(navHostController = navHostController)
        }
        composable(route = NavRoutes.LAUNCHES_SCREEN) {
            LaunchesScreen(navHostController = navHostController)
        }
        composable(route = NavRoutes.LAUNCH_DETAIL) { backStackEntry ->
            val launchId = backStackEntry.arguments?.getString("launchId")?.toLong()
            LaunchDetailScreen(navHostController = navHostController, launchId = launchId)
        }
    }
}