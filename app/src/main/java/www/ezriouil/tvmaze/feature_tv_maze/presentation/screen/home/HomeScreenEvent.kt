package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home

import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow

sealed class HomeScreenEvent {
    data class OnTvShowCardClicked(val tvShow: TvShow) : HomeScreenEvent()
}