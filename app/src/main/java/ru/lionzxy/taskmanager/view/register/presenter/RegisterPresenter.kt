package ru.lionzxy.taskmanager.view.register.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import ru.lionzxy.taskmanager.App
import ru.lionzxy.taskmanager.R
import ru.lionzxy.taskmanager.di.auth.AuthModule
import ru.lionzxy.taskmanager.interactor.auth.IAuthInteractor
import ru.lionzxy.taskmanager.utils.Constants
import ru.lionzxy.taskmanager.view.register.ui.IRegisterView
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

//TODO save login and password here
@InjectViewState
class RegisterPresenter : MvpPresenter<IRegisterView>() {
    @Inject
    lateinit var authInteractor: IAuthInteractor
    private val disposable = CompositeDisposable()

    init {
        App.appComponent.plus(AuthModule()).inject(this)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        if (authInteractor.getToken().isNullOrEmpty().not()) {
            viewState.openMenu()
        }
    }

    fun onClickLogin(login: String, password: String, email: String) {
        if (!validatePasswordAndLogin(login, password)) {
            return
        }
        viewState.onLoading(true)
        disposable.addAll(authInteractor.register(login, password, email)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    viewState.onLoading(false)
                    viewState.openMenu()
                }, {
                    Timber.e(it)
                    viewState.onLoading(false)
                    viewState.onError("Failed register")
                }))
    }

    private fun validatePasswordAndLogin(login: String, password: String): Boolean {
        var loginValid = true
        var passwordValid = true
        if (login.isEmpty()) {
            viewState.showLoginError(R.string.auth_activity_login_empty)
            loginValid = false
        }
        if (!Constants.LOGIN_PATTERN.matcher(login).matches()) {
            viewState.showLoginError(R.string.auth_activity_login_matcher)
            loginValid = false
        }
        if (loginValid) {
            viewState.hideLoginError()
        }
        if (password.isEmpty()) {
            viewState.showPasswordError(R.string.auth_activity_password_empty)
            passwordValid = false
        }
        if (password.length < Constants.PASSWORD_MAX_LENGHT) {
            viewState.showPasswordError(R.string.auth_activity_password_matcher)
            passwordValid = false
        }
        if (passwordValid) {
            viewState.hidePasswordError()
        }
        return passwordValid && loginValid
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}