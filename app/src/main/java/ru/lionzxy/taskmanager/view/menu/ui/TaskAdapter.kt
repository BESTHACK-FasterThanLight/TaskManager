package ru.lionzxy.taskmanager.view.menu.ui

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.di.GlideApp
import ru.lionzxy.taskmanager.utils.generateRandomPassword

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class TaskAdapter(private val users: List<UserApi>, private val login: String) : RecyclerView.Adapter<TaskAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.title.text = user.login
        if (user.login == login) {
            holder.secret.text = user.secret
            holder.secret.setTextColor(Color.GRAY)
        } else {
            holder.secret.text = holder.secret.context.getString(R.string.menu_perm)
            holder.secret.setTextColor(Color.RED)
        }

        GlideApp.with(holder.profile)
                .load("http://api.adorable.io/avatars/285/${generateRandomPassword()}.png")
                .circleCrop()
                .placeholder(R.drawable.ic_account_circle_black_24dp)
                .into(holder.profile)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title = itemView.findViewById<TextView>(R.id.titleSecret)!!
        val secret = itemView.findViewById<TextView>(R.id.textSecret)!!
        val profile = itemView.findViewById<ImageView>(R.id.profile)!!
    }
}