package ru.lionzxy.taskmanager.di.tasks

import dagger.Subcomponent

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@TaskScope
@Subcomponent(modules = [TaskModule::class])
interface TaskComponent {

}