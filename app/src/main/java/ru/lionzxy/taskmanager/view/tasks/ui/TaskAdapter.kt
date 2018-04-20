package ru.lionzxy.taskmanager.view.tasks.ui

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Task

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class TaskAdapter(private val tasks: List<Task>) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_view, parent, false))
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val task = tasks[position]

        holder.title.text = task.name
        holder.description.text = task.name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.taskName)!!
        val description = itemView.findViewById<TextView>(R.id.taskText)!!
    }
}