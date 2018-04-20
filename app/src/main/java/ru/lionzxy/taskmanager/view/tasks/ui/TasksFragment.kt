package ru.lionzxy.taskmanager.view.tasks.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragmeny_menu.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.task.ui.TaskActivity
import ru.lionzxy.taskmanager.view.tasks.presenter.TasksPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 20.04.18
 */

class TasksFragment : MvpAppCompatFragment(), TasksView {
    @InjectPresenter
    lateinit var presenter: TasksPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragmeny_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tabHost.setup()
        var tmp = tabHost.newTabSpec("tag1")
        tmp.setIndicator("To Do")
        tmp.setContent(R.id.rvTodo)
        tabHost.addTab(tmp)

        tmp = tabHost.newTabSpec("tag2")
        tmp.setIndicator("In progress")
        tmp.setContent(R.id.rvProgress)
        tabHost.addTab(tmp)

        tmp = tabHost.newTabSpec("tag3")
        tmp.setIndicator("Ready")
        tmp.setContent(R.id.rvReady)
        tabHost.addTab(tmp)

        rvProgress.layoutManager = LinearLayoutManager(context)
        rvTodo.layoutManager = LinearLayoutManager(context)
        rvReady.layoutManager = LinearLayoutManager(context)
    }

    override fun onResume() {
        super.onResume()
        notifyPresenterAboutAction()
    }

    override fun notifyPresenterAboutAction() {
        val id = arguments?.getInt("id") ?: 0
        presenter.loadList(id)
    }

    override fun onError() {
        context?.toast("Update error")
    }

    override fun showProgress(visible: Boolean) {
        tabHost.visibility = if (visible) View.GONE else View.VISIBLE
        progress.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun setList(tasks: List<Task>) {
        val todoList = ArrayList<Task>()
        val readyList = ArrayList<Task>()
        val progrssList = ArrayList<Task>()

        tasks.forEach {
            when (it.status) {
                2 -> readyList.add(it)
                1 -> progrssList.add(it)
                else -> todoList.add(it)
            }
        }
        rvTodo.adapter = TaskAdapter(todoList) { openTask(it) }
        rvProgress.adapter = TaskAdapter(progrssList) { openTask(it) }
        rvReady.adapter = TaskAdapter(readyList) { openTask(it) }
    }

    private fun openTask(id: Int) {
        val intent = Intent(context, TaskActivity::class.java)
        intent.putExtra("id", id)
        startActivity(intent)
    }

}