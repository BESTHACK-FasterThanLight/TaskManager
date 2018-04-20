package ru.lionzxy.taskmanager.interactor.auth

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.data.auth.UserModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

interface IAuthInteractor {
    fun getToken(): String?

    fun login(login: String, password: String): Single<UserModel>
    fun register(login: String, password: String, secret: String): Single<UserModel>
}