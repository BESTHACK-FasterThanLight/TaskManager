package ru.lionzxy.taskmanager.di.comments

import dagger.Module
import dagger.Provides
import ru.lionzxy.taskmanager.data.auth.ServerApi
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
    fun provideRepo(api: ServerApi): ICommentRepository {
        return CommentRepository(api)
    }

    @Provides
    @CommentScope
    fun provideTaskRepository(api: ServerApi): ITaskRepository {
        return TaskRepository(api)
    }

    @Provides
    @CommentScope
    fun provideInteractor(repository: ICommentRepository, taskRepository: ITaskRepository): ICommentInteractor {
        return CommentInteractor(repository, taskRepository)
    }
}