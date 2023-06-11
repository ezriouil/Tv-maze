package www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.detail_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.TvShowDetail
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.DetailTextInfo
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.ImageNetwork
import www.ezriouil.tvmaze.feature_tv_maze.presentation.screen.component.PersonCard
import www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model.DetailViewModel
import www.ezriouil.tvmaze.util.Resource
import www.ezriouil.tvmaze.util.removeHTMLTags

@Composable
fun DetailScreen(viewModel: DetailViewModel = hiltViewModel()) {
    val detailTvShow by viewModel.detailTvShowState.collectAsState()
    when (detailTvShow) {
        is Resource.Error -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {
                Text(
                    text = (detailTvShow as Resource.Error).error,
                    style = MaterialTheme.typography.h1,
                    color = Color.White
                )
            }
        }
        is Resource.Loading -> {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ) {
                Box(
                    contentAlignment = Center,
                    modifier = Modifier.clip(RoundedCornerShape(16.dp))
                ) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier
                            .background(MaterialTheme.colors.background)
                            .padding(25.dp)
                    )
                }
            }
        }
        is Resource.Success -> {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                (detailTvShow as Resource.Success<TvShowDetail>).data.let {
                    ImageNetwork(
                        image = (detailTvShow as Resource.Success).data.image?.original.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.9f)
                            .clip(RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(modifier = Modifier.fillMaxSize()) {
                        Text(
                            text = it.name.toString(),
                            style = MaterialTheme.typography.h2,
                            color = Color.White,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        DetailTextInfo(
                            modifier = Modifier.padding(horizontal = 5.dp),
                            overflow = TextOverflow.Visible,
                            question = "Description:",
                            answer = it.summary?.removeHTMLTags() ?: "",
                            paddingTextAnswer = 5.dp
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                        ) {
                            DetailTextInfo(
                                question = "language:",
                                answer = it.language ?: "",
                            )
                            DetailTextInfo(
                                question = "rating:",
                                answer = it.rating?.average.toString()
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        DetailTextInfo(
                            question = "Actors:",
                            answer = null,
                        )
                        Spacer(modifier = Modifier.height(6.dp))
                        Log.d("TAG", it.embedded?.cast.toString())
                        it.embedded?.let {
                            it.cast?.let {
                                LazyRow(contentPadding = PaddingValues(all = 12.dp)) {
                                    items(items = it) { cast ->
                                        cast.person?.let { person ->
                                            PersonCard(person = person)
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}