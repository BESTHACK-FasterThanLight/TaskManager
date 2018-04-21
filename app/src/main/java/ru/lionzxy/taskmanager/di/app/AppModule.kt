package ru.lionzxy.taskmanager.di.app

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import com.securepreferences.SecurePreferences
import dagger.Module
import dagger.Provides
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.lionzxy.taskmanager.data.auth.ServerApi
import ru.lionzxy.taskmanager.data.db.AppDatabase
import ru.lionzxy.taskmanager.utils.AddCookiesInterceptor
import ru.lionzxy.taskmanager.utils.ReceivedCookiesInterceptor
import javax.inject.Singleton

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Module
class AppModule(val context: Context) {

    @Singleton
    @Provides
    fun provideContext(): Context = context

    @Singleton
    @Provides
    fun provideSharedPreference(context: Context): SharedPreferences = SecurePreferences(context)

    @Singleton
    @Provides
    fun provideOkHttp(preferences: SharedPreferences): OkHttpClient {
        val pining = CertificatePinner.Builder()
                //.add("trytohack.herokuapp.com",
                //        "sha256/Vuy2zjFSPqF5Hz18k88DpUViKGbABaF3vZx5Raghplc=")
                .build()

        val client = OkHttpClient.Builder()
        client.certificatePinner(pining)
        client.addInterceptor(ReceivedCookiesInterceptor(preferences))
        client.addInterceptor(AddCookiesInterceptor(preferences))
        return client.build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder().client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://193.124.188.85:8081/").build()
    }

    @Singleton
    @Provides
    fun provideDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "app").build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ServerApi {
        return retrofit.create(ServerApi::class.java)
    }
}