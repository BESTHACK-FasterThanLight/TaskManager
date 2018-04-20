package ru.lionzxy.taskmanager.interactor.tasks

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface ITaskInteractor {
    fun getProjects(): Single<List<Project>>
    fun getTasks(): Single<List<Task>>
    fun createProject(project: Project): Completable
    fun createTask(task: Task): Completable
}