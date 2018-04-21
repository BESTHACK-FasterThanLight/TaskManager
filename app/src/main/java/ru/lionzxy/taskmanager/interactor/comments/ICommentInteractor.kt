package ru.lionzxy.taskmanager.interactor.comments

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

interface ICommentInteractor {
    fun getFullTask(id: Int): Single<Pair<Task, List<Comment>>>
    fun sendMessage(text: String, id: Int): Completable
    fun setStatus(status: TaskStatus, id: Int): Single<Pair<Task, List<Comment>>>

    fun removeSecretCommit(id: Int): Completable
}