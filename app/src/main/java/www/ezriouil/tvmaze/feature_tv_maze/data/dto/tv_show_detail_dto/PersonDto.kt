package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto


import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Person

data class PersonDto(
    @SerializedName("birthday")
    val birthday: String? = "",
    @SerializedName("deathday")
    val deathday: Any? = Any(), // null
    @SerializedName("gender")
    val gender: String? = "", // Male
    @SerializedName("id")
    val id: Int? = 0, // 88
    @SerializedName("image")
    val image: ImageXXDto? = ImageXXDto(),
    @SerializedName("name")
    val name: String? = "", // James Caviezel
    @SerializedName("updated")
    val updated: Int? = 0, // 1658836964
    @SerializedName("url")
    val url: String? = "" // https://www.tvmaze.com/people/88/james-caviezel
) {
    fun toPerson(): Person {
        return Person(birthday, gender, image?.toImageXX(), name)
    }
}