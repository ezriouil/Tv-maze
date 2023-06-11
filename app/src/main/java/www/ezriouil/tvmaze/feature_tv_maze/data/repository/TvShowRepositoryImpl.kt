package www.ezriouil.tvmaze.feature_tv_maze.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import www.ezriouil.tvmaze.feature_tv_maze.data.api.ApiTvMaze
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.TvShowDetail
import www.ezriouil.tvmaze.feature_tv_maze.domain.repository.TvShowsRepository
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

class TvShowRepositoryImpl @Inject constructor(private val apiTvMaze: ApiTvMaze) :
    TvShowsRepository {
    override suspend fun getTvShows(): Flow<Resource<List<TvShow>>> {
        val response = apiTvMaze.getTvShows()
        return flow {
            emit(Resource.Loading)
            try {
                if (response.isSuccessful) {
                    emit(Resource.Success(data = response.body()!!.map { it.toTvShow() }))
                } else {
                    emit(Resource.Error(error = response.message()))
                }
            } catch (e: Exception) {
                emit(Resource.Error(error = e.message?:"we have error"))
            }
        }
    }

    override suspend fun getDetailTvShow(idTvShow: Int): Flow<Resource<TvShowDetail>> {
        val response = apiTvMaze.getDetailTvShow(idTvShow)
        return flow {
            emit(Resource.Loading)
            try {
                if (response.isSuccessful) {
                    emit(Resource.Success(data = response.body()!!.toTvShowDetail()))
                } else emit(Resource.Error(error = "Error 404 Wrote by me"))
            } catch (e: Exception) {
                emit(Resource.Error(error = e.localizedMessage ?: ""))
            }
        }
    }
}


