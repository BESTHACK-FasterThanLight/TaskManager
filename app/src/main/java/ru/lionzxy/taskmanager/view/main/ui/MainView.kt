package ru.lionzxy.taskmanager.view.main.ui

import com.arellomobile.mvp.MvpView
import ru.lionzxy.taskmanager.data.model.Project

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface MainView : MvpView {
    fun setProjectList(projects: List<Project>)
}