package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName

data class ScheduleDto(
    @SerializedName("days")
    val days: List<String?>? = null,
    @SerializedName("time")
    val time: String? = null // 22:00
)