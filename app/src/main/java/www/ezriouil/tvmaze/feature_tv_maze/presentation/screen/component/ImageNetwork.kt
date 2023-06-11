package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil.compose.rememberAsyncImagePainter

@Composable
fun ImageNetwork(image: String, modifier: Modifier) {
    Image(
        painter = rememberAsyncImagePainter(
            model = image,
            placeholder = painterResource(id = R.drawable.ic_menu_rotate),
            filterQuality = FilterQuality.Medium
        ),
        modifier = modifier
            .fillMaxWidth(0.5f)
            .fillMaxHeight(),
        contentDescription = null,
        contentScale = ContentScale.Crop
    )
}