package ru.lionzxy.taskmanager.di.tasks

import dagger.Subcomponent
import ru.lionzxy.taskmanager.view.menu.presenter.TaskPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@TaskScope
@Subcomponent(modules = [TaskModule::class])
interface TaskComponent {
    fun inject(presenter: TaskPresenter)
}