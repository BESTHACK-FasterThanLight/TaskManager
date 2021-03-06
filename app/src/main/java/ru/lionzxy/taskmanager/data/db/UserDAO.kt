package ru.lionzxy.taskmanager.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import ru.lionzxy.taskmanager.data.auth.UserApi

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 28.03.18
 */

@Dao
abstract class UserDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(list: List<UserApi>)
}