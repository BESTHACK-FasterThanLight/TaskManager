package ru.lionzxy.taskmanager.repositories.comments

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.view.task.ui.TaskStatus

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface ICommentRepository {
    fun getComments(id: Int): Single<List<Comment>>
    fun sendMessage(text: String, id: Int): Completable
    fun setStatus(status: TaskStatus, task: Task): Single<Task>

    fun removeSecretCommit(id: Int): Completable
}