package ru.lionzxy.taskmanager.di.tasks

import dagger.Subcomponent
import ru.lionzxy.taskmanager.view.menu.presenter.MainPresenter
import ru.lionzxy.taskmanager.view.task.presenter.TaskPresenter
import ru.lionzxy.taskmanager.view.tasks.presenter.TasksPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@TaskScope
@Subcomponent(modules = [TaskModule::class])
interface TaskComponent {
    fun inject(presenter: MainPresenter)
    fun inject(presenter: TasksPresenter)
}