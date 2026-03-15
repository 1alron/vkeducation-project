package io.alron.vkeducationproject.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.alron.vkeducationproject.presentation.appdetails.AppDetailsScreen
import io.alron.vkeducationproject.presentation.applist.AppListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.AppList.route
    ) {
        composable(Route.AppList.route) {
            AppListScreen(
                onAppClick = { appDetailsId ->
                    navController.navigate(Route.AppDetails.createRoute(appDetailsId))
                }
            )
        }

        composable(
            route = Route.AppDetails.route,
            arguments = listOf(
                navArgument("appDetailsId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val appDetailsId = backStackEntry.arguments?.getString("appDetailsId") ?: ""

            AppDetailsScreen(
                appDetailsId = appDetailsId,
                onBackClick = {
                    navController.popBackStack()
                },
                modifier = Modifier
                    .fillMaxSize()
                    .safeDrawingPadding()
            )
        }
    }
}