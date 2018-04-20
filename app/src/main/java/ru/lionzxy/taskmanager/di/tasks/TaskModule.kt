package ru.lionzxy.taskmanager.di.tasks

import dagger.Module
import dagger.Provides
import ru.lionzxy.taskmanager.interactor.tasks.ITaskInteractor
import ru.lionzxy.taskmanager.interactor.tasks.TaskInteractor
import ru.lionzxy.taskmanager.repositories.tasks.ITaskRepository
import ru.lionzxy.taskmanager.repositories.tasks.TaskRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@TaskScope
@Module
class TaskModule {

    @Provides
    @TaskScope
    fun provideInteractor(repository: ITaskRepository): ITaskInteractor {
        return TaskInteractor(repository)
    }

    @Provides
    @TaskScope
    fun provideRepository(): ITaskRepository {
        return TaskRepository()
    }
}