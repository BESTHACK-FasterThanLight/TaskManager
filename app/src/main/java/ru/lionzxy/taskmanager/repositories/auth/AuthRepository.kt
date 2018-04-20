package ru.lionzxy.taskmanager.repositories.auth

import android.content.SharedPreferences
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import ru.lionzxy.taskmanager.data.auth.TryToHackApi
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.data.auth.UserModel
import ru.lionzxy.taskmanager.data.db.AppDatabase

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthRepository(private val sharedPreferences: SharedPreferences,
                     appDatabase: AppDatabase,
                     retrofit: Retrofit) : IAuthRepository {
    val userDao = appDatabase.getUserDao()
    val api = retrofit.create(TryToHackApi::class.java)

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
        return api.login(login, password).toSingle { UserModel(login, "") }
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    putToken(login) // Вставляем токен, если успешно
                }
    }

    override fun register(login: String, password: String, secret: String): Single<UserModel> {
        return api.register(login, password, secret).toSingle { UserModel(login, "") }
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    putToken(login)
                }
    }

    override fun get(): Single<List<UserApi>> {
        return api.get()
                .subscribeOn(Schedulers.io())
                .doAfterSuccess {
                    userDao.insertAll(it)
                }
    }
}