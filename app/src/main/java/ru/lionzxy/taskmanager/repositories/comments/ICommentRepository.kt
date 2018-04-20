package ru.lionzxy.taskmanager.repositories.comments

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

interface ICommentRepository {
    fun getComments(id: Int): Single<List<Comment>>
}