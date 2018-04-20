package ru.lionzxy.taskmanager.view.tasks.ui

import com.arellomobile.mvp.MvpView
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface TasksView : MvpView {
    fun setList(tasks: List<Task>)
}