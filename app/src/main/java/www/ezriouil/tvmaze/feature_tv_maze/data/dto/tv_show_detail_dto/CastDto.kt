package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Cast
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Person

data class CastDto(
    @SerializedName("character")
    val character: CharacterDto? = CharacterDto(),
    @SerializedName("person")
    val person: PersonDto? = PersonDto(),
    @SerializedName("self")
    val self: Boolean? = false, // false
    @SerializedName("voice")
    val voice: Boolean? = false // false
){
    fun toCast(): Cast{
        return Cast(person = person?.toPerson())
    }
}