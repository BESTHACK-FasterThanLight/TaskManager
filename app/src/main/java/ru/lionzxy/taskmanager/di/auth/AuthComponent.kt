package ru.lionzxy.taskmanager.di.auth

import dagger.Subcomponent
import ru.lionzxy.taskmanager.view.auth.presenter.AuthPresenter
import ru.lionzxy.taskmanager.view.menu.presenter.TaskPresenter
import ru.lionzxy.taskmanager.view.register.presenter.RegisterPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@Subcomponent(modules = [AuthModule::class])
@AuthScope
interface AuthComponent {
    fun inject(presenter: AuthPresenter)
    fun inject(presenter: RegisterPresenter)
    fun inject(presenter: TaskPresenter)
}