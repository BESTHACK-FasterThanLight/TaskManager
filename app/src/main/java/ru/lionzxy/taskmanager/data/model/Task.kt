package ru.lionzxy.taskmanager.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

data class Task(
        @SerializedName("title")
        var name: String,
        @SerializedName("text")
        var description: String,
        @SerializedName("status")
        var status: Int,
        @SerializedName("id")
        var id: Int) {
    constructor() : this("", "", 0, 0)
}