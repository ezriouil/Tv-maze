package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import www.ezriouil.tvmaze.ui.theme.Black1
import www.ezriouil.tvmaze.ui.theme.Kaiseiopti

@Composable
fun CustomText(
    textAlign: TextAlign = TextAlign.Center,
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Black1,
    fontWeight: FontWeight = FontWeight.Medium,
    textSize: Int = 18,
    maxLiens: Int = 1,
    textDecoration: TextDecoration = TextDecoration.None
) {
    Text(
        text = text,
        color = textColor,
        style = TextStyle(
            fontFamily = Kaiseiopti,
            fontWeight = fontWeight,
            fontSize = textSize.sp
        ),
        modifier = modifier,
        textAlign = textAlign,
        maxLines = maxLiens,
        textDecoration = textDecoration
    )
}