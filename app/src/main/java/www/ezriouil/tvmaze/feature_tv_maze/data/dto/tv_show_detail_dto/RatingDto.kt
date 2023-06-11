package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Rating

data class RatingDto(
    @SerializedName("average")
    val average: Double? = null // 8.8
){
    fun toRating(): Rating{
        return Rating(average = average)
    }
}