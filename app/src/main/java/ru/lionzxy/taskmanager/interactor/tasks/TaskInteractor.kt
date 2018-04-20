package ru.lionzxy.taskmanager.interactor.tasks

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.repositories.tasks.ITaskRepository

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class TaskInteractor(private val repository: ITaskRepository) : ITaskInteractor {
    override fun getTasks(id: Int): Single<List<Task>> {
        return repository.getTasks(id)
    }

    override fun getProjects(): Single<List<Project>> {
        return repository.getProjects()
    }

    override fun createProject(project: Project): Completable {
        return repository.createProject(project)
    }

    override fun createTask(task: Task): Completable {
        return repository.createTask(task)
    }
}