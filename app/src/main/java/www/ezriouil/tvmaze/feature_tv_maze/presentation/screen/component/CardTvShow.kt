package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show.TvShow

@Composable
fun CardTvShow(
    modifier: Modifier = Modifier,
    tvShow: TvShow,
    titleColor: Color,
    onClick: (Int)->Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(250.dp)
            .padding(start = 10.dp, top = 5.dp, bottom = 5.dp, end = 5.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable { onClick(tvShow.id!!) },
        border = BorderStroke(2.dp, color = Color.LightGray)
    ) {
        Row(
            modifier = modifier.fillMaxSize()
        ) {
            //Image
            ImageNetwork(image = tvShow.
            image?.medium!!, modifier = modifier)
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(all = 5.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                //Title
                TextInfo(
                    modifier = modifier,
                    question = "title",
                    answer = tvShow.name!!,
                    answerColor = titleColor
                )
                //Language
                TextInfo(
                    modifier = modifier,
                    question = "language",
                    answer = tvShow.language!!,
                    answerColor = titleColor
                )
                //Rating
                TextInfo(
                    modifier = modifier,
                    question = "rating",
                    answer = tvShow.rating?.average.toString(),
                    answerColor = titleColor
                )
                //Description
                TextDescription(
                    modifier = modifier,
                    title = "summary",
                    description = tvShow.summary!!,
                    descColor = titleColor
                )
            }
        }
    }
}