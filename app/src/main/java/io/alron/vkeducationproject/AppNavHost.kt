package io.alron.vkeducationproject

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.alron.vkeducationproject.appdetails.AppDetailsScreen
import io.alron.vkeducationproject.applist.AppListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.AppList.route
    ) {
        composable(Route.AppList.route) {
            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(Route.AppDetails.createRoute(appId))
                }
            )
        }

        composable(
            route = Route.AppDetails.route,
            arguments = listOf(
                navArgument("appId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getInt("appId") ?: 0

            AppDetailsScreen(
                appId = appId,
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