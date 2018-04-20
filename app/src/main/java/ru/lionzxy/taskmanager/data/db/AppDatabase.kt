package ru.lionzxy.taskmanager.data.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ru.lionzxy.taskmanager.data.auth.UserApi

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 28.03.18
 */

@Database(entities = [(UserApi::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getUserDao(): UserDAO
}