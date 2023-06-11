package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.Person

@Composable
fun PersonCard(
    modifier: Modifier = Modifier,
    person: Person
) {
    Card(
        modifier = modifier
            .requiredWidth(250.dp)
            .fillMaxHeight(0.5f)
            .padding(horizontal = 4.dp),
        shape = RoundedCornerShape(12.dp),
        backgroundColor = MaterialTheme.colors.background,
        contentColor = Color.White,
        border = BorderStroke(width = 1.dp, color = Color.White),
        elevation = 8.dp
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .requiredHeight(200.dp)
                    .align(CenterHorizontally)
                    .padding(top = 8.dp)
                    .clip(CutCornerShape(8.dp))
            ) {
                ImageNetwork(image = person.image?.original ?: "", modifier = modifier.fillMaxSize())
            }
            Spacer(modifier = modifier.height(8.dp))
            TextInfo(
                modifier = modifier.padding(start = 12.dp),
                question = "full name:",
                answer = person.name ?: "",
                answerColor = Color.White,
                textStyleQuestion = MaterialTheme.typography.h4,
                textStyleAnswer = MaterialTheme.typography.h3
            )
            Spacer(modifier = modifier.height(8.dp))
            TextInfo(
                modifier = modifier.padding(start = 12.dp),
                question = "birthday:",
                answer = person.birthday ?: "",
                answerColor = Color.White,
                textStyleQuestion = MaterialTheme.typography.h4,
                textStyleAnswer = MaterialTheme.typography.h3
            )
            Spacer(modifier = modifier.height(8.dp))
            TextInfo(
                modifier = modifier.padding(start = 12.dp),
                question = "gender:",
                answer = person.gender ?: "",
                answerColor = Color.White,
                textStyleQuestion = MaterialTheme.typography.h4,
                textStyleAnswer = MaterialTheme.typography.h3
            )
            Spacer(modifier = modifier.height(8.dp))
        }
    }
}

