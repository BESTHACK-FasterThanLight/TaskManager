package ru.lionzxy.taskmanager.view.tasks.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface TasksView : MvpView {
    fun setList(tasks: List<Task>)
    @StateStrategyType(SkipStrategy::class)
    fun notifyPresenterAboutAction()

    @StateStrategyType(SkipStrategy::class)
    fun onError()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress(visible: Boolean)
}