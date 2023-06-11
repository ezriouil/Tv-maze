package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName

data class ExternalsDto(
    @SerializedName("imdb")
    val imdb: String? = null, // tt1839578
    @SerializedName("thetvdb")
    val thetvdb: Int? = null, // 248742
    @SerializedName("tvrage")
    val tvrage: Int? = null // 28376
)