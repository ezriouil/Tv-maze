package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.CardTvShow
import www.ezriouil.tvmaze.util.ManageUI

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    state: HomeScreenState,
    event: (HomeScreenEvent) -> Unit
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(items = state.tvShows, key = { it.id!! }) { tvShowItem ->
            CardTvShow(
                modifier = Modifier,
                titleColor = Color.White,
                tvShow = tvShowItem
            ) {
                navController.navigate(ManageUI.DetailScreen.route + "/$it")
            }
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(16.dp))
    ) {
        if (state.isLoading) {
            CircularProgressIndicator(
                color = Color.White,
                modifier = modifier
                    .background(MaterialTheme.colors.background)
                    .padding(25.dp)
            )
        }
        if (state.error != null && !state.isLoading && state.tvShows.isEmpty()) {
            Text(
                text = state.error,
                style = MaterialTheme.typography.h1,
                color = Color.White
            )
        }
    }

}
