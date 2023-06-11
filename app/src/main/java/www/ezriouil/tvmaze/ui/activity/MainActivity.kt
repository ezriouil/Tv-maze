package www.ezriouil.tvmaze.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.index.IndexScreen
import www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model.HomeViewModel
import www.ezriouil.tvmaze.ui.theme.TvMazeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //private lateinit var connectivityObserver: ConnectivityObserver
    private val viewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //installSplashScreen().setKeepOnScreenCondition { viewModel.splashScreen.value }
        //connectivityObserver = NetworkConnectivityObserver(context = this)
        setContent {
            val navController = rememberNavController()
            TvMazeTheme {
                IndexScreen(
                    navController = navController,
                    state = viewModel.state,
                    event = viewModel::onEvent
                )
            }
        }
    }
}
/*
val result by connectivityObserver.observe().collectAsState(initial = ConnectivityObserver.Status.UNAVAILABLE)
            when(result){
                ConnectivityObserver.Status.AVAILABLE -> TODO()
                ConnectivityObserver.Status.UNAVAILABLE -> TODO()
                ConnectivityObserver.Status.LOST -> TODO()
            }
 */