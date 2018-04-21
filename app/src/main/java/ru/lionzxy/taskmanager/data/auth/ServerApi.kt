package ru.lionzxy.taskmanager.data.auth

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

interface ServerApi {
    @GET("login.php")
    fun login(@Query("login")
              login: String,
              @Query("password")
              password: String): Completable
    @GET("register.php")
    fun register(@Query("login")
                 login: String,
                 @Query("password")
                 password: String,
                 @Query("secret")
                 secret: String): Completable

    @GET("get.php")
    fun get(): Single<List<UserApi>>
}