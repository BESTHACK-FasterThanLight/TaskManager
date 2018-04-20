package ru.lionzxy.taskmanager.di.comments

import dagger.Subcomponent
import ru.lionzxy.taskmanager.view.task.presenter.TaskPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@CommentScope
@Subcomponent(modules = [CommentModule::class])
interface CommentComponent {
    fun inject(presenter: TaskPresenter)
}