package ru.lionzxy.taskmanager.interactor.comments

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface ICommentInteractor {
    fun getFullTask(id: Int): Single<Pair<Task, List<Comment>>>
}