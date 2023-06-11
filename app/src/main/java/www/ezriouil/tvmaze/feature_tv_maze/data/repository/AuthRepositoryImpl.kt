package www.ezriouil.tvmaze.feature_tv_maze.data.repository

import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import www.ezriouil.tvmaze.feature_tv_maze.domain.repository.AuthRepository
import www.ezriouil.tvmaze.util.Resource
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val firebaseAuth: FirebaseAuth) :
    AuthRepository {

    override fun signUp(
        fullName: String,
        email: String,
        password: String
    ): Flow<Resource<Boolean>> = flow {
        var isSuccess = false
        var errorMsg = ""
        emit(Resource.Loading)
        try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener {
                isSuccess = true
            }.addOnFailureListener {
                errorMsg = it.localizedMessage
            }
            delay(2500)
            if (isSuccess) {
                emit(Resource.Success(data = isSuccess))
                delay(1500)
                emit(Resource.Success(data = false))
            } else emit(Resource.Error(error = errorMsg))
        } catch (e: Exception) {
            emit(Resource.Error(error = e.localizedMessage ?: "We have an error"))
        }
    }

    override fun singIn(email: String, password: String): Flow<Resource<Boolean>> =
        flow {
            var isSuccess = false
            var errorMsg = ""
            emit(Resource.Loading)
            try {
                firebaseAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                    isSuccess = true
                }.addOnFailureListener {
                    errorMsg = it.localizedMessage
                }
                delay(2500)

                if (isSuccess) {
                    emit(Resource.Success(data = isSuccess))
                    delay(2000)
                    emit(Resource.Success(data = false))
                } else emit(Resource.Error(error = errorMsg))
            } catch (e: Exception) {
                emit(Resource.Error(error = e.localizedMessage ?: "We have an error"))
            }
        }
}