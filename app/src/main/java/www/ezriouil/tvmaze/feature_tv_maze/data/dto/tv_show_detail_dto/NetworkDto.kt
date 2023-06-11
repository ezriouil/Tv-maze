package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName

data class NetworkDto(
    @SerializedName("id")
    val id: Int? = 0, // 2
    @SerializedName("name")
    val name: String? = "", // CBS
    @SerializedName("officialSite")
    val officialSite: String? = "" // https://www.cbs.com/
)