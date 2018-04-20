package ru.lionzxy.taskmanager.di.auth

import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.lionzxy.taskmanager.data.db.AppDatabase
import ru.lionzxy.taskmanager.interactor.auth.AuthInteractor
import ru.lionzxy.taskmanager.interactor.auth.IAuthInteractor
import ru.lionzxy.taskmanager.repositories.auth.AuthRepository
import ru.lionzxy.taskmanager.repositories.auth.IAuthRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Module
@AuthScope
class AuthModule {
    @Provides
    @AuthScope
    fun provideRepository(sharedPreferences: SharedPreferences, retrofit: Retrofit): IAuthRepository {
        return AuthRepository(sharedPreferences, retrofit)
    }


    @Provides
    @AuthScope
    fun provideInteractor(authRepository: IAuthRepository): IAuthInteractor {
        return AuthInteractor(authRepository)
    }
}