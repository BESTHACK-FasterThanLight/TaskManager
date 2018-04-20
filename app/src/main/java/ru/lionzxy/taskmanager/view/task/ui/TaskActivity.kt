package ru.lionzxy.taskmanager.view.task.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_task.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Comment
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.task.presenter.TaskPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class TaskActivity : MvpAppCompatActivity(), TaskView {
    @InjectPresenter
    lateinit var presenter: TaskPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task)

        comments.layoutManager = LinearLayoutManager(this)
    }

    override fun setTask(task: Task, commentList: List<Comment>) {
        titleText.text = task.name
        description.text = task.description

        comments.adapter = CommentAdapter(commentList, {})
    }

    override fun showProgress(visible: Boolean) {
        progress.visibility = if (visible) View.VISIBLE else View.GONE
        content.visibility = if (visible) View.GONE else View.VISIBLE
        inputField.visibility = if (visible) View.GONE else View.VISIBLE
    }

    override fun onError() {
        toast("Update error")
    }

    override fun notifyPresenterAboutAction() {
        val id = intent.getIntExtra("id", 0)
        presenter.loadTask(id)
    }
}