package ru.lionzxy.taskmanager.di.project

import dagger.Subcomponent
import ru.lionzxy.taskmanager.view.main.presenter.MainPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@Subcomponent(modules = [ProjectModule::class])
@ProjectScope
interface ProjectComponent {
    fun inject(presenter: MainPresenter)
}