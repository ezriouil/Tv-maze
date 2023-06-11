package www.ezriouil.tvmaze.feature_tv_maze.data.dto.tv_show_detail_dto

import com.google.gson.annotations.SerializedName
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Embedded

data class EmbeddedDto(
    @SerializedName("cast")
    val cast: List<CastDto>? = listOf()
) {
    fun toEmbedded(): Embedded {
        return Embedded(cast?.map { it.toCast() })
    }
}