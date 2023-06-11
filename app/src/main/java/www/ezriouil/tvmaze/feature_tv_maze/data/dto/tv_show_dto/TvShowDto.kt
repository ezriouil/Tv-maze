package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow

data class TvShowDto(
    @SerializedName("genres")
    val genres: List<String?>? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("image")
    val imageDto: ImageDto? = null,
    @SerializedName("language")
    val language: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("rating")
    val ratingDto: RatingDto? = null,
    @SerializedName("summary")
    val summary: String? = null
) {
    fun toTvShow(): TvShow {
        return TvShow(
            genres,
            id,
            imageDto?.toImage(),
            language,
            name,
            ratingDto?.toRating(),
            summary
        )
    }
}