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

class TaskRepository : ITaskRepository {
    override fun getProjects(): Single<List<Project>> {
        return Single.just(listOf(Project("test", 1)))
    }

    override fun getTasks(): Single<List<Task>> {
        return Single.just(listOf(Task("task", "Test task")))
    }

    override fun createProject(project: Project): Completable {
        return Completable.complete()
    }

    override fun createTask(task: Task): Completable {
        return Completable.complete()
    }
}