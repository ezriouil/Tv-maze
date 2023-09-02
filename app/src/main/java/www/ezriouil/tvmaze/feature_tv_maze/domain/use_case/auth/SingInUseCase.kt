package www.ezriouil.tvmaze.feature_tv_maze.domain.use_case.auth

import kotlinx.coroutines.flow.Flow
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.AuthRepositoryImpl
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

class SingInUseCase @Inject constructor(private val repositoryImpl: AuthRepositoryImpl) {

    operator fun invoke(email: String, password: String): Flow<Resource<Boolean>> =
        repositoryImpl.singIn(email = email, password = password)

}
