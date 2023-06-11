package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun DetailTextInfo(
    modifier: Modifier = Modifier,
    question: String,
    answer: String?,
    answerColor: Color = Color.White,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    paddingTextAnswer: Dp = 30.dp
) {
    Column {
        Text(
            text = question,
            color = Color.LightGray,
            style = MaterialTheme.typography.h6,
            textDecoration = TextDecoration.Underline
        )
        if (answer!=null){
            Spacer(modifier = modifier.height(3.dp))
            Text(
                text = answer,
                color = answerColor,
                style = MaterialTheme.typography.h5,
                overflow = overflow,
                modifier = modifier.padding(start = paddingTextAnswer)
            )
        }

    }
}
