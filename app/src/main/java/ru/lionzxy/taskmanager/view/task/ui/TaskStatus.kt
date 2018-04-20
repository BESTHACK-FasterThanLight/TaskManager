package ru.lionzxy.taskmanager.view.task.ui

import android.graphics.Color
import android.support.annotation.ColorInt
import android.support.annotation.ColorRes
import ru.lionzxy.taskmanager.R

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 21.04.18
 */

enum class TaskStatus(val id: Int, @ColorRes val colorRes: Int, val textRes: String) {
    TODO(0, R.color.color_todo, "To Do"),
    PROGRESS(1, R.color.color_progress, "In Progress"),
    READY(2, R.color.color_ready, "Ready")
}