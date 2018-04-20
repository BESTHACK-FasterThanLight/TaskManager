package ru.lionzxy.taskmanager.di.comments

import dagger.Module
import dagger.Provides
import ru.lionzxy.taskmanager.interactor.comments.CommentInteractor
import ru.lionzxy.taskmanager.interactor.comments.ICommentInteractor
import ru.lionzxy.taskmanager.repositories.comments.CommentRepository
import ru.lionzxy.taskmanager.repositories.comments.ICommentRepository

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
    fun provideInteractor(repository: ICommentRepository): ICommentInteractor {
        return CommentInteractor(repository)
    }
}