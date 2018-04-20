package ru.lionzxy.taskmanager.di.project

import dagger.Module
import dagger.Provides
import ru.lionzxy.taskmanager.interactor.project.IProjectInteractor
import ru.lionzxy.taskmanager.interactor.project.ProjectInteractor
import ru.lionzxy.taskmanager.repositories.project.IProjectRepository
import ru.lionzxy.taskmanager.repositories.project.ProjectRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@Module
@ProjectScope
class ProjectModule {

    @Provides
    @ProjectScope
    fun provideRepo(): IProjectRepository {
        return ProjectRepository()
    }

    @Provides
    @ProjectScope
    fun provideInteractor(repository: IProjectRepository): IProjectInteractor {
        return ProjectInteractor(repository)
    }
}