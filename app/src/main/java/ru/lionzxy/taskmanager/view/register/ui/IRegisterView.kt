package ru.lionzxy.taskmanager.view.register.ui

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.SkipStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType

/**
 * @author Nikita Kulikov <nikita@kulikof.ru>
 * @project SecretBook
 * @date 06.03.18
 */

@StateStrategyType(AddToEndSingleStrategy::class)
interface IRegisterView : MvpView {
    fun onLoading(isEnable: Boolean)
    @StateStrategyType(SkipStrategy::class)
    fun onError(test: String)

    fun showLoginError(resError: Int)
    fun showPasswordError(resError: Int)
    fun showSecretError(resError: Int)
    fun hideLoginError()
    fun hidePasswordError()
    fun hideSecretError()

    fun openMenu()
}