package ru.lionzxy.taskmanager.utils

import android.content.Context
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.widget.Toast
import java.util.*

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

fun Context.toast(resId: Int) {
    Toast.makeText(this, resId, Toast.LENGTH_LONG).show()
}

fun Context.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun generateRandomPassword(): String {
    val chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    var passWord = ""
    for (i in 0..31) {
        passWord += chars[Math.floor(Math.random() * chars.length).toInt()]
    }
    return passWord
}

@ColorInt
@Suppress("DEPRECATION")
fun Context.getColorOld(@ColorRes resId: Int): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        this.resources.getColor(resId, this.theme)
    } else {
        this.resources.getColor(resId)
    }
}