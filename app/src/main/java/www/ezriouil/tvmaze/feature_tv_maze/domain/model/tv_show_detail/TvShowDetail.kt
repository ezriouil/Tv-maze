package www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail

data class TvShowDetail(
    val embedded: Embedded? = Embedded(),
    val genres: List<String>? = listOf(),
    val image: ImageXX? = ImageXX(),
    val language: String? = "",
    val name: String? = "",
    val rating: Rating? = Rating(),
    val summary: String? = "",
    val url: String? = "",
)