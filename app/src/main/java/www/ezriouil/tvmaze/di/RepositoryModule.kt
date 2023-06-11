package www.ezriouil.tvmaze.di

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import www.ezriouil.tvmaze.application.MyApplication
import www.ezriouil.tvmaze.feature_tv_maze.data.api.ApiTvMaze
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.AuthRepositoryImpl
import www.ezriouil.tvmaze.feature_tv_maze.data.repository.TvShowRepositoryImpl
import www.ezriouil.tvmaze.feature_tv_maze.domain.use_case.auth.SingUpUseCase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideMyApplication(@ApplicationContext context: Context): MyApplication{
        return context as MyApplication
    }

    @Provides
    @Singleton
    fun provideTvShowRepositoryImply(apiTvMaze: ApiTvMaze): TvShowRepositoryImpl {
        return TvShowRepositoryImpl(apiTvMaze)
    }

    @Provides
    @Singleton
    fun provideAuthRepositoryImpl(firebaseAuth: FirebaseAuth): AuthRepositoryImpl {
        return AuthRepositoryImpl(firebaseAuth)
    }

    @Provides
    @Singleton
    fun provideAuthUseCase(repositoryImpl: AuthRepositoryImpl): SingUpUseCase {
        return SingUpUseCase(repositoryImpl)
    }
}