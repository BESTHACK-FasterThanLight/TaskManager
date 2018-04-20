package ru.lionzxy.taskmanager.view.menu.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.lionzxy.taskmanager.data.model.Project

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

interface ITaskActivity : MvpView {
    fun setProjects(projects: List<Project>)
    fun onProjectCreated()
    fun onError()
    @StateStrategyType(AddToEndSingleStrategy::class)
    fun openTask(id: Int)
}