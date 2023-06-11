package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.index

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.auth.SignUpScreen
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.auth.SingInScreen
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.detail_screen.DetailScreen
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home.HomeScreen
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home.HomeScreenEvent
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home.HomeScreenState
import www.ezriouil.tvmaze.util.ManageUI

@Composable
fun IndexScreen(
    navController: NavHostController,
    state: HomeScreenState,
    event: (HomeScreenEvent) -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = ManageUI.SingInScreen.route
    ) {
        composable(route = ManageUI.SingUpScreen.route) {
            SignUpScreen(navHostController = navController)
        }
        composable(route = ManageUI.SingInScreen.route) {
            SingInScreen(navHostController = navController)
        }
        composable(route = ManageUI.HomeScreen.route) {
            HomeScreen(navController = navController, state = state, event = event)
        }
        composable(route = ManageUI.DetailScreen.route + "/{id}") {
            DetailScreen()
        }
    }
}