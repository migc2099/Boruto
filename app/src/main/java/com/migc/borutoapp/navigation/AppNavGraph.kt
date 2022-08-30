package com.migc.borutoapp.navigation

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.migc.borutoapp.presentation.screens.details.DetailsScreen
import com.migc.borutoapp.presentation.screens.home.HomeScreen
import com.migc.borutoapp.presentation.screens.search.SearchScreen
import com.migc.borutoapp.presentation.screens.splash.SplashScreen
import com.migc.borutoapp.presentation.screens.welcome.WelcomeScreen
import com.migc.borutoapp.utils.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalMaterialApi
@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navHostController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {
            DetailsScreen(navHostController = navController)
        }
        composable(route = Screen.Search.route) {
            SearchScreen(navController)
        }
    }
}