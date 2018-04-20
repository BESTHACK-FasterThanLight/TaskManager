package ru.lionzxy.taskmanager.interactor.comments

import io.reactivex.Completable
import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.repositories.comments.ICommentRepository
import ru.lionzxy.taskmanager.repositories.tasks.ITaskRepository
import ru.lionzxy.taskmanager.view.task.ui.TaskStatus

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class CommentInteractor(private val repository: ICommentRepository, private val taskRepository: ITaskRepository) : ICommentInteractor {
    override fun getFullTask(id: Int): Single<Pair<Task, List<Comment>>> {
        return taskRepository.getFullTask(id).flatMap { task ->
            repository.getComments(id)
                    .map { task to it }
        }
    }

    override fun sendMessage(text: String, id: Int): Completable {
        return repository.sendMessage(text, id)
    }

    override fun setStatus(status: TaskStatus, id: Int): Single<Pair<Task, List<Comment>>> {
        return getFullTask(id).flatMap { pair ->
            repository.setStatus(status, pair.first).map {
                it to pair.second
            }
        }
    }
}