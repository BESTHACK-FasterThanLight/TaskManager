package ru.lionzxy.taskmanager.view.menu.ui

import com.arellomobile.mvp.MvpView
import ru.lionzxy.taskmanager.data.auth.UserApi

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project TryToHack
 * @date 27.03.18
 */

interface IUserMenuActivity : MvpView {
    fun setList(users: List<UserApi>, login: String)
    fun onError()
}