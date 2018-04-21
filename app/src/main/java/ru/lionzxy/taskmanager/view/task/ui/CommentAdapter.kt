package ru.lionzxy.taskmanager.view.task.ui

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.utils.CommentTimer
import java.util.*
import kotlin.collections.ArrayList

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class CommentAdapter(private var comments: List<Comment>,
                     private val onRemovePrivate: ((id: Int) -> Unit),
                     private val activity: Activity)
    : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    companion object {
        const val SECRETTYPE = 1
        const val SIMPLY = 2

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            SECRETTYPE -> HiddenViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hidden_comment_open, parent, false))
            else -> ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment, parent, false))
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (comments[position].secret) {
            return SECRETTYPE
        }
        return SIMPLY
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]

        holder.name.text = comment.author
        holder.description.text = comment.text

        if (holder is HiddenViewHolder) {
            holder.hidden.setOnClickListener {
                holder.hidden.visibility = View.GONE
                holder.timerClock?.cancel()
                holder.timerClock = Timer()
                holder.timer.text = "01:00"
                holder.timerClock?.schedule(CommentTimer(holder.timer, activity, {
                    onRemovePrivate.invoke(comment.id)
                    comments = ArrayList(comments)
                    (comments as ArrayList).remove(comment)
                    notifyDataSetChanged()
                }), 1000, 1000)

            }
        }
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)!!
        val description = itemView.findViewById<TextView>(R.id.comment)!!
    }

    class HiddenViewHolder(itemView: View) : ViewHolder(itemView) {
        val hidden = itemView.findViewById<View>(R.id.hidden)
        val timer = itemView.findViewById<TextView>(R.id.timer)
        var timerClock: Timer? = null
    }
}