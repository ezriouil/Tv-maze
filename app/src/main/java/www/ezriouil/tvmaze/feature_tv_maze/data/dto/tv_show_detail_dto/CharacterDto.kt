package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_dto.ImageDto

data class CharacterDto(
    @SerializedName("id")
    val id: Int? = null, // 64
    @SerializedName("image")
    val image: ImageDto? = null,
    @SerializedName("name")
    val name: String? = null, // John Reese
    @SerializedName("url")
    val url: String? = null // https://www.tvmaze.com/characters/64/person-of-interest-john-reese
)