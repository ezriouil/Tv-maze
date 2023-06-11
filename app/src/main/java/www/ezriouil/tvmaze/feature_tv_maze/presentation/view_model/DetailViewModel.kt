package www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.TvShowRepositoryImpl
import www.ezriouil.tvmaze.feature_tv_maze.domain.model.tv_show_detail.TvShowDetail
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val repositoryImpl: TvShowRepositoryImpl,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _detailTvShowState = MutableStateFlow<Resource<TvShowDetail>>(Resource.Loading)
    val detailTvShowState = _detailTvShowState.asStateFlow()

    init {
        val idOfTheShow = savedStateHandle.get<String>("id")?.toInt()!!
        viewModelScope.launch {
            val result = repositoryImpl.getDetailTvShow(idOfTheShow)
            delay(1000)
            result.collect { state ->
                _detailTvShowState.update { state }
            }
        }
    }
}