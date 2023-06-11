package www.ezriouil.tvmaze.util

sealed class ManageUI(val route: String) {
    object SingUpScreen : ManageUI(route = "UpScreenRoute")
    object SingInScreen : ManageUI(route = "InScreenRoute")
    object HomeScreen : ManageUI(route = "homeScreenRoute")
    object DetailScreen : ManageUI(route = "detailScreenRoute")
}