package ru.lionzxy.taskmanager.view.add_task.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import kotlinx.android.synthetic.main.activity_add_task.*
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Task
import ru.lionzxy.taskmanager.di.tasks.TaskModule
import ru.lionzxy.taskmanager.interactor.tasks.ITaskInteractor
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.menu.ui.MainActivity
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 21.04.18
 */

class AddTaskActivity : AppCompatActivity() {
    @Inject
    lateinit var interactor: ITaskInteractor

    init {
        App.appComponent.plus(TaskModule()).inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        add.setOnClickListener {
            val task = Task(name.text.toString(), text.text.toString(), 0, 0)
            setProgress(true)
            interactor.createTask(task).subscribe({
                setProgress(false)
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }, {
                Timber.e(it)
                toast("Ошибка. Я не хочу описывать ошибку, я хочу спать!")
                setProgress(false)
            })
        }
    }

    private fun setProgress(visible: Boolean) {
        progress.visibility = if (visible) View.VISIBLE else View.GONE
        content.visibility = if (visible) View.GONE else View.VISIBLE
    }
}