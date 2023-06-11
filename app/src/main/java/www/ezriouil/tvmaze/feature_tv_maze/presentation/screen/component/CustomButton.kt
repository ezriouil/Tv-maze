package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import www.ezriouil.tvmaze.ui.theme.Black1
import www.ezriouil.tvmaze.ui.theme.Kaiseiopti

@Composable
fun CustomButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.White,
    corner: Int = 12,
    textColor: Color = Black1,
    fontWeight: FontWeight = FontWeight.SemiBold,
    enable: Boolean = true
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(0.75f)
            .requiredHeight(55.dp)
            .clip(RoundedCornerShape(size = corner.dp)),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = backgroundColor,
            contentColor = textColor
        ), enabled = enable
    ) {
        Text(
            text = text,
            color = textColor,
            style = TextStyle(
                fontFamily = Kaiseiopti,
                fontWeight = fontWeight,
                fontSize = 18.sp
            ),
            modifier = modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
        )
    }
}