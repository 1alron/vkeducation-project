package io.alron.vkeducationproject.presentation

internal sealed class Route(val route: String) {

    object AppList : Route("app_list")

    object AppDetails : Route("app_details/{appDetailsId}") {
        fun createRoute(appDetailsId: String) = "app_details/$appDetailsId"
    }
}