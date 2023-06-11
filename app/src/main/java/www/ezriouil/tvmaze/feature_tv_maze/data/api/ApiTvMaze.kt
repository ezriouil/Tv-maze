package www.ezriouil.tvmaze.feature_tv_maze.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto.TvShowDetailDto
import www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto.TvShowDto

interface ApiTvMaze {

    @GET("shows")
    suspend fun getTvShows(): Response<List<TvShowDto>>

    @GET("shows/{id}?embed=cast")
    suspend fun getDetailTvShow(@Path("id") tvShowId: Int): Response<TvShowDetailDto>

}
