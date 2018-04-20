package ru.lionzxy.taskmanager.view.menu.ui

import com.arellomobile.mvp.MvpView
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

interface ITaskActivity : MvpView {
    fun setProjects(projects: List<Project>)
    fun onProjectCreated()
    fun onError()
}