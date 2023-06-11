package www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show

import www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto.ImageDto
import www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto.RatingDto

data class TvShow(
    val genres: List<String?>? = null,
    val id: Int? = null,
    val image: Image? = null,
    val language: String? = null,
    val name: String? = null,
    val rating: Rating? = null,
    val summary: String? = null
)
