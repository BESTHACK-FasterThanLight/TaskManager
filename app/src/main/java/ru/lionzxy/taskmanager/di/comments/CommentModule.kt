package ru.lionzxy.taskmanager.di.comments

import dagger.Module
import dagger.Provides
import ru.lionzxy.taskmanager.interactor.comments.CommentInteractor
import ru.lionzxy.taskmanager.interactor.comments.ICommentInteractor
import ru.lionzxy.taskmanager.repositories.comments.CommentRepository
import ru.lionzxy.taskmanager.repositories.comments.ICommentRepository
import ru.lionzxy.taskmanager.repositories.tasks.ITaskRepository
import ru.lionzxy.taskmanager.repositories.tasks.TaskRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

@Module
@CommentScope
class CommentModule {

    @Provides
    @CommentScope
    fun provideRepo(): ICommentRepository {
        return CommentRepository()
    }

    @Provides
    @CommentScope
    fun provideTaskRepository(): ITaskRepository {
        return TaskRepository()
    }

    @Provides
    @CommentScope
    fun provideInteractor(repository: ICommentRepository, taskRepository: ITaskRepository): ICommentInteractor {
        return CommentInteractor(repository, taskRepository)
    }
}