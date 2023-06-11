package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TextInfo(
    modifier: Modifier,
    question: String,
    answer: String,
    answerColor: Color,
    textStyleQuestion: TextStyle = MaterialTheme.typography.h6,
    textStyleAnswer: TextStyle = MaterialTheme.typography.h5
) {
    Column(modifier = modifier) {
        Text(
            text = question,
            color = Color.LightGray,
            style = textStyleQuestion,
            textDecoration = TextDecoration.Underline
        )
        Spacer(modifier = modifier.height(3.dp))
        Text(
            text = answer,
            color = answerColor,
            style = textStyleAnswer,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = modifier.padding(start = 5.dp)
        )
    }
}