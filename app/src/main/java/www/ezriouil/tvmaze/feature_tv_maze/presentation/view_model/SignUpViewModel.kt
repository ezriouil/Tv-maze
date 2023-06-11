package www.ezriouil.tvmaze.feature_tv_maze.presentation.view_model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import www.ezriouil.tvmaze.feature_tv_maze.domain.use_case.auth.SingUpUseCase
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val singUpUseCase: SingUpUseCase) : ViewModel() {

    private val _stateSingUp = MutableStateFlow<Resource<Boolean>>(Resource.Success(data = false))
    val stateSingUp: StateFlow<Resource<Boolean>> = _stateSingUp

    var fullNameTextField by mutableStateOf("")
    var emailTextField by mutableStateOf("")
    var passwordTextField by mutableStateOf("")

    fun onSubmit() {
        viewModelScope.launch {
            singUpUseCase(fullNameTextField, emailTextField, passwordTextField).collect { result ->
                _stateSingUp.update { result }
            }
        }
    }

}