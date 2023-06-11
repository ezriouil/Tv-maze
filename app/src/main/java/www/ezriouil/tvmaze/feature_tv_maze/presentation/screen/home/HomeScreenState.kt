package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home

import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow

data class HomeScreenState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val tvShows: List<TvShow> = emptyList()
)
