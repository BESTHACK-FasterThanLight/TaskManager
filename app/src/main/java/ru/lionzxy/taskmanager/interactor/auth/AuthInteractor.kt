package ru.lionzxy.taskmanager.interactor.auth

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.data.auth.UserModel
import ru.lionzxy.taskmanager.repositories.auth.IAuthRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthInteractor(private val authRepository: IAuthRepository) : IAuthInteractor {
    override fun getToken(): String? {
        return authRepository.getToken()
    }

    override fun login(login: String, password: String): Single<UserModel> {
        return authRepository.login(login, password)
    }

    override fun register(login: String, password: String, secret: String): Single<UserModel> {
        return authRepository.register(login, password, secret)
    }

    override fun get(): Single<List<UserApi>> {
        return authRepository.get()
    }
}