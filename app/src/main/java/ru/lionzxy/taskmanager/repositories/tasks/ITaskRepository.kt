package ru.lionzxy.taskmanager.repositories.tasks

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface ITaskRepository {
    fun getProjects(): Single<List<Project>>
    fun getTasks(id: Int): Single<List<Task>>
    fun createProject(project: Project): Completable
    fun createTask(task: Task): Completable
}