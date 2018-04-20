package ru.lionzxy.taskmanager.view.register.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.activity_register.*
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.utils.toast
import ru.lionzxy.taskmanager.view.auth.ui.AuthActivity
import ru.lionzxy.taskmanager.view.menu.ui.UserMenuActivity
import ru.lionzxy.taskmanager.view.register.presenter.RegisterPresenter

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

class RegisterActivity : MvpAppCompatActivity(), IRegisterView {
    @InjectPresenter
    lateinit var authPresenter: RegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_register)

        buttonLogin.setOnClickListener {
            authPresenter.onClickLogin(editTextLogin.text.toString(),
                    editTextPassword.text.toString(),
                    editTextSecret.text.toString())
        }

        auth_login_button.setOnClickListener {
            val login = Intent(baseContext, AuthActivity::class.java)
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(login)
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

    override fun showSecretError(resError: Int) {
        errorSecretText.visibility = View.VISIBLE
        errorSecretText.text = getText(resError)
    }

    override fun hideLoginError() {
        errorLoginText.visibility = View.GONE
    }

    override fun hidePasswordError() {
        errorPasswordText.visibility = View.GONE
    }

    override fun hideSecretError() {
        errorSecretText.visibility = View.GONE
    }

    override fun openMenu() {
        val intent = Intent(baseContext, UserMenuActivity::class.java)
        startActivity(intent)
    }
}