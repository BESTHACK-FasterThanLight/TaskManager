package ru.lionzxy.taskmanager

import android.app.Application
import ru.lionzxy.taskmanager.di.app.AppComponent
import ru.lionzxy.taskmanager.di.app.AppModule
import ru.lionzxy.taskmanager.di.app.DaggerAppComponent

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 05.03.18
 */
class App : Application() {
    companion object {
        @JvmStatic
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}