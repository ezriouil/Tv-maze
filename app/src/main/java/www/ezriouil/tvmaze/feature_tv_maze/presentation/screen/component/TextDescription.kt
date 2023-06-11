package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import www.ezriouil.tvmaze.util.removeHTMLTags

@Composable
fun TextDescription(modifier: Modifier, title: String, description: String, descColor: Color) {
    Text(
        text = title,
        color = Color.LightGray,
        style = MaterialTheme.typography.h6,
        textDecoration = TextDecoration.Underline
    )
    Spacer(modifier = modifier.height(3.dp))
    Text(
        text = description.removeHTMLTags(),
        color = descColor,
        style = MaterialTheme.typography.subtitle2,
        maxLines = 3,
        overflow = TextOverflow.Ellipsis,
        modifier = modifier.padding(start = 5.dp, bottom = 5.dp)
    )
}