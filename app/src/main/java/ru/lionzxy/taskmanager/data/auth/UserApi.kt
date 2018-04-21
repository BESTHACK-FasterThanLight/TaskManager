package ru.lionzxy.taskmanager.data.auth

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

@Entity(tableName = "users")
data class UserApi(
        @SerializedName("email")
        var email: String? = null,
        @PrimaryKey
        @SerializedName("username")
        var username: String? = null,
        @SerializedName("password")
        var password: String? = null) {
    constructor() : this(null, "")
}