package ru.lionzxy.taskmanager.data.model

import com.google.gson.annotations.SerializedName

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

data class Comment(
        @SerializedName("text")
        var text: String,
        @SerializedName("authorLogin")
        var author: String,
        @SerializedName("secret")
        var secret: Boolean,
        @SerializedName("id")
        var id: Int) {
    constructor() : this("", "", false, 0)
}