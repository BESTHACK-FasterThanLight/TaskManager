package ru.lionzxy.taskmanager.repositories.auth

import android.content.SharedPreferences
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import ru.lionzxy.taskmanager.data.auth.ServerApi
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.data.auth.UserModel

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthRepository(private val sharedPreferences: SharedPreferences,
                     private val api: ServerApi) : IAuthRepository {
    override fun getToken(): String? {
        val token = sharedPreferences.getString("auth_token", "")

        return if (token.isNullOrEmpty()) {
            null
        } else token
    }

    private fun putToken(token: String) {
        sharedPreferences.edit().putString("auth_token", token).apply()
    }

    override fun login(login: String, password: String): Single<UserModel> {
        return api.login(UserApi(null, login, password)).toSingle { UserModel(login, "") }
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    putToken(login) // Вставляем токен, если успешно
                }
    }

    override fun register(login: String, password: String, secret: String): Single<UserModel> {
        return api.register(login, password, secret).toSingle { UserModel(login, secret) }
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    putToken(login)
                }
    }
}