package ru.lionzxy.taskmanager.repositories.comments

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.auth.ServerApi
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.view.task.ui.TaskStatus

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class CommentRepository(private val api: ServerApi) : ICommentRepository {
    override fun getComments(id: Int): Single<List<Comment>> {
        return Single.just(listOf(Comment("Text", "Author", false, 1),
                Comment("Text", "Author", true, 2)))
    }

    override fun sendMessage(text: String, id: Int, secret: Boolean): Completable {
        return Completable.complete()
    }

    override fun setStatus(status: TaskStatus, task: Task): Single<Task> {
        task.status = status.id
        return Single.just(task)
    }

    override fun removeSecretCommit(id: Int): Completable {
        return Completable.complete()
    }
}