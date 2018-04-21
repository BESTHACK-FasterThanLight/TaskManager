package ru.lionzxy.taskmanager.data.auth

import io.reactivex.Completable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

interface ServerApi {
    @POST("login")
    fun login(@Body userApi: UserApi): Completable
    @GET("signup")
    fun register(@Body userApi: UserApi): Completable

    @GET("get.php")
    fun get(): Single<List<UserApi>>
}