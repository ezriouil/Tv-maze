package www.ezriouil.tvmaze.feature_tv_maze.domain.repository

import kotlinx.coroutines.flow.Flow
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.TvShowDetail
import www.ezriouil.tvmaze.util.Resource

interface TvShowsRepository {

    suspend fun getTvShows(): Flow<Resource<List<TvShow>>>

    suspend fun getDetailTvShow(idTvShow: Int): Flow<Resource<TvShowDetail>>

}