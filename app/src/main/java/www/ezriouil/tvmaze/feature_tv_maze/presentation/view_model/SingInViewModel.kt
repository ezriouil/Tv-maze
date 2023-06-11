package www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import www.ezriouil.tvmaze.feature_tv_maze.domain.use_case.auth.SingInUseCase
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

@HiltViewModel
class SingInViewModel @Inject constructor(
    private val singInUseCase: SingInUseCase
) : ViewModel() {

    private val _singInState =
        MutableStateFlow<Resource<Boolean>>(Resource.Success(data = false))
    val singInState = _singInState.asStateFlow()

    var emailTextField by mutableStateOf("")
    var passwordTextField by mutableStateOf("")

    fun onSubmit(email: String, password: String) {
        viewModelScope.launch {
            singInUseCase(email = email, password = password).collect { result ->
                _singInState.update { result }
            }
        }
    }

}