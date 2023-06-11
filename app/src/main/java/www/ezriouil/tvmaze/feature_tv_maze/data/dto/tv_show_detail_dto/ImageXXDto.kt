package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.ImageXX

data class ImageXXDto(
    @SerializedName("medium")
    val medium: String? = null, // https://static.tvmaze.com/uploads/images/medium_portrait/163/407679.jpg
    @SerializedName("original")
    val original: String? = null // https://static.tvmaze.com/uploads/images/original_untouched/163/407679.jpg
) {
    fun toImageXX(): ImageXX {
        return ImageXX(medium, original)
    }
}