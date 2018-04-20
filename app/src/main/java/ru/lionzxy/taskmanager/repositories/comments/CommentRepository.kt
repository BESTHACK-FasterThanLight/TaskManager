package ru.lionzxy.taskmanager.repositories.comments

import io.reactivex.Single
import ru.lionzxy.taskmanager.data.model.Comment

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class CommentRepository : ICommentRepository {
    override fun getComments(id: Int): Single<List<Comment>> {
        return Single.just(listOf(Comment("Text", "Author")))
    }

}