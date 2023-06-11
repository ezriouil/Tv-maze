package www.ezriouil.tvmaze.feature_tv_maze.domain.repository

import kotlinx.coroutines.flow.Flow
import www.ezriouil.tvmaze.util.Resource

interface AuthRepository {
    fun signUp(fullName: String, email: String, password: String): Flow<Resource<Boolean>>
    fun singIn(email: String, password: String): Flow<Resource<Boolean>>
}