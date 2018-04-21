package ru.lionzxy.taskmanager.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

data class Project(
        @SerializedName("name")
        var name: String,
        @SerializedName("id")
        var id: Int) {
    constructor() : this("", 0)
}