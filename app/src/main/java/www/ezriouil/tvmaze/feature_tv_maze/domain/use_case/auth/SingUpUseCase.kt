package www.ezriouil.tvmaze.feature_tv_maze.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.AuthRepositoryImpl
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

class SingUpUseCase @Inject constructor(private val repository: AuthRepositoryImpl) {
    operator fun invoke(
        fullName: String,
        email: String,
        password: String
    ): Flow<Resource<Boolean>> =
        repository.signUp(fullName = fullName, email = email, password = password)
}