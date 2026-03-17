package io.alron.vkeducationproject

sealed class Route(val route: String) {

    object AppList : Route("app_list")

    object AppDetails : Route("app_details/{appId}") {
        fun createRoute(appId: Int) = "app_details/$appId"
    }
}