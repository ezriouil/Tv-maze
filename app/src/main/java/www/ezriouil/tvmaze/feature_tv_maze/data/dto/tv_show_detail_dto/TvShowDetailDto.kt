package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.TvShowDetail

data class TvShowDetailDto(
    @SerializedName("averageRuntime")
    val averageRuntime: Int? = 0, // 60
    @SerializedName("dvdCountry")
    val dvdCountry: Any? = Any(), // null
    @SerializedName("_embedded")
    val embedded: EmbeddedDto? = EmbeddedDto(),
    @SerializedName("ended")
    val ended: String? = "", // 2016-06-21
    @SerializedName("externals")
    val externals: ExternalsDto? = ExternalsDto(),
    @SerializedName("genres")
    val genres: List<String>? = listOf(),
    @SerializedName("id")
    val id: Int? = 0, // 2
    @SerializedName("image")
    val image: ImageXXDto? = ImageXXDto(),
    @SerializedName("language")
    val language: String? = "",
    @SerializedName("name")
    val name: String? = "", // Person of Interest
    @SerializedName("network")
    val network: NetworkDto? = NetworkDto(),
    @SerializedName("officialSite")
    val officialSite: String? = "", // http://www.cbs.com/shows/person_of_interest/
    @SerializedName("premiered")
    val premiered: String? = "", // 2011-09-22
    @SerializedName("rating")
    val rating: RatingDto? = RatingDto(),
    @SerializedName("runtime")
    val runtime: Int? = 0, // 60
    @SerializedName("schedule")
    val schedule: ScheduleDto? = ScheduleDto(),
    @SerializedName("status")
    val status: String? = "", // Ended
    @SerializedName("summary")
    val summary: String? = "", // <p>You are being watched. The government has a secret system, a machine that spies on you every hour of every day. I know because I built it. I designed the Machine to detect acts of terror but it sees everything. Violent crimes involving ordinary people. People like you. Crimes the government considered "irrelevant". They wouldn't act so I decided I would. But I needed a partner. Someone with the skills to intervene. Hunted by the authorities, we work in secret. You'll never find us. But victim or perpetrator, if your number is up, we'll find you.</p>
    @SerializedName("type")
    val type: String? = "", // Scripted
    @SerializedName("updated")
    val updated: Int? = 0, // 1678119582
    @SerializedName("url")
    val url: String? = "", // https://www.tvmaze.com/shows/2/person-of-interest
    @SerializedName("webChannel")
    val webChannel: Any? = Any(), // null
    @SerializedName("weight")
    val weight: Int? = 0 // 98
) {
    fun toTvShowDetail(): TvShowDetail {
        return TvShowDetail(
            embedded?.toEmbedded(),
            genres,
            image?.toImageXX(),
            language,
            name,
            rating?.toRating(),
            summary,
            url
        )
    }
}