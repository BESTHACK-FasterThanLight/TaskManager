package ru.lionzxy.taskmanager.di.app

import dagger.Component
import ru.lionzxy.taskmanager.di.auth.AuthComponent
import ru.lionzxy.taskmanager.di.auth.AuthModule
import ru.lionzxy.taskmanager.di.comments.CommentComponent
import ru.lionzxy.taskmanager.di.comments.CommentModule
import ru.lionzxy.taskmanager.di.project.ProjectComponent
import ru.lionzxy.taskmanager.di.project.ProjectModule
import ru.lionzxy.taskmanager.di.tasks.TaskComponent
import ru.lionzxy.taskmanager.di.tasks.TaskModule
import javax.inject.Singleton

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */
@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun plus(module: AuthModule): AuthComponent
    fun plus(module: ProjectModule): ProjectComponent
    fun plus(module: TaskModule): TaskComponent
    fun plus(module: CommentModule): CommentComponent
}