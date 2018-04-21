package ru.lionzxy.taskmanager.utils

import android.content.Context
import android.os.Build
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import android.widget.Toast
import java.util.*
import java.lang.reflect.AccessibleObject.setAccessible
import dalvik.system.DexClassLoader
import java.io.File
import java.nio.file.Files.exists



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

/**
 * Get the current Xposed version installed on the device.
 *
 * @param context The application context
 * @return The Xposed version or `null` if Xposed isn't installed.
 */
fun getXposedVersion(context: Context): Int? {
    try {
        val xposedBridge = File("/system/framework/XposedBridge.jar")
        if (xposedBridge.exists()) {
            val optimizedDir = context.getDir("dex", Context.MODE_PRIVATE)
            val dexClassLoader = DexClassLoader(xposedBridge.getPath(),
                    optimizedDir.path, null, ClassLoader.getSystemClassLoader())
            val XposedBridge = dexClassLoader.loadClass("de.robv.android.xposed.XposedBridge")
            val getXposedVersion = XposedBridge.getDeclaredMethod("getXposedVersion")
            if (!getXposedVersion.isAccessible) getXposedVersion.isAccessible = true
            return getXposedVersion.invoke(null) as Int
        }
    } catch (ignored: Exception) {
    }

    return null
}