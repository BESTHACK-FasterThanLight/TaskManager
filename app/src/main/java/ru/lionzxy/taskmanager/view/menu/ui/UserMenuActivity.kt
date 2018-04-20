package ru.lionzxy.taskmanager.view.menu.ui

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_users.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.data.auth.UserApi
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.menu.presenter.UserMenuPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

class UserMenuActivity : MvpAppCompatActivity(), IUserMenuActivity {
    @InjectPresenter
    lateinit var presenter: UserMenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)

        list.layoutManager = LinearLayoutManager(this)
        updateButton.setOnRefreshListener { presenter.loadList() }
    }

    override fun setList(users: List<UserApi>, login: String) {
        list.adapter = UserModelAdapter(users, login)
        updateButton.isRefreshing = false
    }

    override fun onError() {
        toast("Update error")
    }
}