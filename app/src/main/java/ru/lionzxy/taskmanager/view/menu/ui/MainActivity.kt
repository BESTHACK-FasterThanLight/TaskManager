package ru.lionzxy.taskmanager.view.menu.ui

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import kotlinx.android.synthetic.main.toolbar.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.model.Project
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.menu.presenter.MainPresenter
import ru.lionzxy.taskmanager.view.tasks.ui.TasksFragment

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class MainActivity : MvpAppCompatActivity(), IMainActivity {
    @InjectPresenter
    lateinit var presenter: MainPresenter
    var drawer: Drawer? = null
    var project: TasksFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }

    override fun setProjects(projects: List<Project>) {
        val items = projects.map { PrimaryDrawerItem().withIdentifier(it.id.toLong()).withName(it.name) }
        drawer = DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .addDrawerItems(*items.toTypedArray(),
                        DividerDrawerItem(),
                        PrimaryDrawerItem()
                                .withIdentifier(200)
                                .withName(R.string.add_project)
                                .withSelectable(false))
                .withOnDrawerItemClickListener { view, position, item ->
                    if (item.identifier == 200L) {
                        createProject()
                        return@withOnDrawerItemClickListener false
                    }

                    presenter.openTasks(item.identifier.toInt())
                    return@withOnDrawerItemClickListener false
                }
                .build()

    }

    override fun onProjectCreated() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun createProject() {

    }

    override fun openTask(id: Int) {
        val args = Bundle()
        args.putInt("id", id)
        val tmp = TasksFragment()
        tmp.arguments = args
        supportFragmentManager.beginTransaction().replace(R.id.container, tmp).commit()
    }

    override fun onError() {
        toast("Update error")
    }
}