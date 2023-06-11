package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.Image

data class ImageDto(
    @SerializedName("medium")
    val medium: String? = null,
    @SerializedName("original")
    val original: String? = null
) {
    fun toImage(): Image {
        return Image(medium = medium, original = original)
    }
}