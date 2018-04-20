package ru.lionzxy.taskmanager.view.task.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Comment

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class CommentAdapter(private val comments: List<Comment>, private val listener: ((id: Int) -> Unit)) : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.comment, parent, false))
    }

    override fun getItemCount() = comments.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comment = comments[position]

        holder.name.text = comment.author
        holder.name.text = comment.text
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.name)!!
        val description = itemView.findViewById<TextView>(R.id.comment)!!
    }
}