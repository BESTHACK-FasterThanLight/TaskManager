package ru.lionzxy.taskmanager.view.auth.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_auth.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.auth.presenter.AuthPresenter
import ru.lionzxy.taskmanager.view.menu.ui.TaskListActivity
import ru.lionzxy.taskmanager.view.register.ui.RegisterActivity

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class AuthActivity : MvpAppCompatActivity(), IAuthView {
    @InjectPresenter
    lateinit var authPresenter: AuthPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_auth)

        buttonLogin.setOnClickListener {
            authPresenter.onClickLogin(editTextLogin.text.toString(),
                    editTextPassword.text.toString())
        }

        auth_register.setOnClickListener {
            val register = Intent(baseContext, RegisterActivity::class.java)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(register)
        }
    }

    override fun onLoading(isEnable: Boolean) {
        progressLogin.visibility = if (isEnable) View.VISIBLE else View.GONE
        buttonLogin.visibility = if (isEnable) View.GONE else View.VISIBLE
    }

    override fun onError(test: String) {
        toast(test)
    }

    override fun showLoginError(resError: Int) {
        errorLoginText.visibility = View.VISIBLE
        errorLoginText.text = getString(resError)
    }

    override fun showPasswordError(resError: Int) {
        errorPasswordText.visibility = View.VISIBLE
        errorPasswordText.text = getText(resError)
    }

    override fun hideLoginError() {
        errorLoginText.visibility = View.GONE
    }

    override fun hidePasswordError() {
        errorPasswordText.visibility = View.GONE
    }

    override fun openMenu() {
        val intent = Intent(baseContext, TaskListActivity::class.java)
        startActivity(intent)
    }
}