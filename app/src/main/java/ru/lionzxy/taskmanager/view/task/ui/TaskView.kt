package ru.lionzxy.taskmanager.view.task.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface TaskView : MvpView {
    @StateStrategyType(SkipStrategy::class)
    fun notifyPresenterAboutAction()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun setTask(task: Task, commentList: List<Comment>)

    fun clearInput()

    @StateStrategyType(AddToEndSingleStrategy::class)
    fun showProgress(visible: Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun onError()
}