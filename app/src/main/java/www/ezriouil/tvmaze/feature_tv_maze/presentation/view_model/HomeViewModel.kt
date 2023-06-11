package www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.TvShowRepositoryImpl
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home.HomeScreenEvent
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home.HomeScreenState
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val tvShowRepositoryImpl: TvShowRepositoryImpl
) : ViewModel() {

    var state by mutableStateOf(HomeScreenState())

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnTvShowCardClicked -> {

            }
        }
    }

    init {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            tvShowRepositoryImpl.getTvShows().collect { result ->
                state = when (result) {
                    is Resource.Loading -> {
                        state.copy(isLoading = true)
                    }
                    is Resource.Error -> {
                        state.copy(isLoading = false, tvShows = emptyList(), error = result.error)
                    }
                    is Resource.Success -> {
                        state.copy(isLoading = false, tvShows = result.data, error = null)
                    }
                }

            }


        }
    }

}

//Splash Screen

//private val _splashScreen: MutableState<Boolean> = mutableStateOf(false)
//val splashScreen: State<Boolean> = _splashScreen
//_splashScreen.value = true
//_splashScreen.value = false