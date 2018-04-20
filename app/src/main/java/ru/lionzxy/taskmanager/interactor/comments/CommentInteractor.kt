package ru.lionzxy.taskmanager.interactor.comments

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.repositories.comments.ICommentRepository
import ru.lionzxy.taskmanager.repositories.tasks.ITaskRepository

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

}